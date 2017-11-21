package com.hr.framework.ldap;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestExpenseProcess {

    private String filename = "/Users/tmichels/Documents/workspace-sts-3.5.0.M21/nucleus-business-process/src/main/resources/diagrams/expense_process.bpmn";

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();

    @Test
    public void startProcess() throws Exception {
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createStandaloneInMemProcessEngineConfiguration()
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .setMailServerHost("smtp.gmail.com")
                .setMailServerPort(587)
                .setMailServerUsername("youremail@gmail.com")
                .setMailServerPassword("password")
                .setMailServerUseSSL(true)
                .setMailServerUseTLS(true)
                .buildProcessEngine();

        RuntimeService runtimeService = activitiRule.getRuntimeService();

        RepositoryService repositoryService = activitiRule.getRepositoryService();
        repositoryService.createDeployment().addInputStream("expense_process.bpmn",
                new FileInputStream(filename)).deploy();

        Map<String, Object> variableMap1 = new HashMap<String, Object>();
        variableMap1.put("employee", "Jack");
        variableMap1.put("amount", 111);
        Map<String, Object> variableMap2 = new HashMap<String, Object>();
        variableMap2.put("employee", "Jonny");
        variableMap2.put("amount", 222);
        Map<String, Object> variableMap3 = new HashMap<String, Object>();
        variableMap3.put("employee", "Pete");
        variableMap3.put("amount", 333);

        ProcessInstance processInstance1 = runtimeService.startProcessInstanceByKey("expenseProcess", variableMap1);
        ProcessInstance processInstance2 = runtimeService.startProcessInstanceByKey("expenseProcess", variableMap2);
        ProcessInstance processInstance3 = runtimeService.startProcessInstanceByKey("expenseProcess", variableMap3);
        System.out.println("**** ProcessInstance1 ID *** " + processInstance1.getId());

        assertNotNull(processInstance1.getId());
        assertNotNull(processInstance2.getId());
        assertNotNull(processInstance3.getId());


        Map<String, Object> processVariables = runtimeService.getVariables(processInstance1.getId());
        for (String processVariable : processVariables.keySet()){
            System.out.println("PROCESS KEY : " + processVariable + " VALUE: " + processVariables.get(processVariable));
        }

        TaskService taskService = processEngine.getTaskService();

        //Query Task Available for Kermit
        List<Task> availableTasksForKermit = taskService.createTaskQuery().taskAssignee("kermit").list();
        for (Task task : availableTasksForKermit) {
            System.out.println(" *******AVAILABLE TASK**********" + "\n"
                    +   " Task Name: " + task.getName() + "\n Owner: " + task.getOwner() + "\n" +
                    " Assignee: " + task.getAssignee() +"\n "+ "Description: " + task.getDescription());
        }

        List<Task> tasks = activitiRule.getTaskService().createTaskQuery().list();
        for (Task task : tasks){
            System.out.println("*******LIST TASKS************" + "\n" +
                    "Get Task:" + task.getAssignee());
        }

        List<Task> kermitTasks = taskService.createTaskQuery()
                .taskAssignee("kermit")
                .processVariableValueEquals("amount", 111)
                .orderByDueDate().asc()
                .list();

        for (Task kermitTask: kermitTasks){
            System.out.println("*******QUERY FOR ASSIGNEE TASKS************" + "\n" + kermitTask.getAssignee());
        }

        //Can't Claim Task as this task already has an assignee
        if (availableTasksForKermit.get(0).getAssignee()==null)
            taskService.claim(availableTasksForKermit.get(0).getId(), "rocky");

        //Verify Task - No Tasks for Rocky cause Kermit has it
        tasks = taskService.createTaskQuery().taskAssignee("rocky").list();
        for (Task task : tasks) {
            System.out.println("Task for rocky: " + task.getName());
        }

        //Ok kermit claims a tasks
        taskService.claim(availableTasksForKermit.get(0).getId(), "kermit");

        List<Task> claimedTasks = taskService.createTaskQuery().taskCandidateOrAssigned("kermit").list();
        for (Task claimedTask : claimedTasks){
            System.out.println("Task claimed by Kermit: " + claimedTask.getDescription());
        }

        Map<String, Object> taskCompleteVariables = new HashMap<String, Object>();
        taskCompleteVariables.put("employeeVerification", false);
        taskCompleteVariables.put("amountVerificaion", true);
        taskService.complete(availableTasksForKermit.get(0).getId(),taskCompleteVariables);

        System.out.println("Number of tasks for kermit: "
                + taskService.createTaskQuery().taskAssignee("kermit").count());

        List<Task> accountancyTasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
        for (Task accountancyTask : accountancyTasks){
            System.out.println("Accountancy Task: " +accountancyTask.getDescription());
        }

        taskService.claim(accountancyTasks.get(0).getId(), "sandy");

        System.out.println("Number of tasks for Sandy: "
                + taskService.createTaskQuery().taskAssignee("sandy").count());

        System.out.println("BreakPoint Timeout");

        System.out.println("Number of tasks for Sandy: "
                + taskService.createTaskQuery().taskAssignee("sandy").count());

        //Query Task Available for Kermit
        List<Task> availableTasksForKermit2 = taskService.createTaskQuery().taskAssignee("kermit").list();
        for (Task task : availableTasksForKermit2) {
            System.out.println(" *******AVAILABLE TASK**********" + "\n"
                    +   " Task Name: " + task.getName() + "\n Owner: " + task.getOwner() + "\n" +
                    " Assignee: " + task.getAssignee() +"\n "+ "Description: " + task.getDescription());
        }

        taskService.claim(accountancyTasks.get(0).getId(), "sandy");
        taskService.complete(accountancyTasks.get(0).getId());

        HistoryService historyService = processEngine.getHistoryService();
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance1.getId()).singleResult();
        System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
    }
}
