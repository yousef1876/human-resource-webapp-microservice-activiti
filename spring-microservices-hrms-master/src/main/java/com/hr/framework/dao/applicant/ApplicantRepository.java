package com.hr.framework.dao.applicant;

import com.hr.framework.dao.applicant.interfaces.IApplicantRepository;
import com.hr.framework.po.applicant.Applicant;
import com.hr.framework.po.applicant.Applicant_;
import org.joda.time.LocalDate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ApplicantRepository extends JdbcDaoSupport implements IApplicantRepository  {




    @PersistenceContext(unitName = "LOCAL_PERSISTENCE_UNIT")
    private EntityManager em;

    public List<Applicant> findByApplicant(Applicant model){

        /*LocalDate today = new LocalDate();*/

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Applicant> query = builder.createQuery(Applicant.class);
        Root<Applicant> root = query.from(Applicant.class);

        Predicate hasBirthday = builder.equal(root.get(Applicant_.idNo), 1);
        Predicate isLongTermCustomer = builder.equal(root.get(Applicant_.login),"admin " );
        query.where(builder.and(hasBirthday, isLongTermCustomer));

        return em.createQuery(query.select(root)).getResultList();
    }
}
