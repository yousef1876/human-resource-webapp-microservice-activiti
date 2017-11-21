package com.hr.framework.config.activiti.ldap;

import org.activiti.ldap.LDAPConfigurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class LDAPConfiguration {

    @Bean
    public LDAPConfigurator LDAPConfig(){
        LDAPConfigurator ldapConfig = new LDAPConfigurator();

        ldapConfig.setServer("localhost");
        ldapConfig.setPort(10389);
        ldapConfig.setUser("uid=admin,ou=system");
        ldapConfig.setPassword("secret");

        ldapConfig.setBaseDn("");
        ldapConfig.setQueryUserByUserId("(&(objectClass=inetOrgPerson)(uid={0}))");
        ldapConfig.setQueryUserByFullNameLike("(&(objectClass=inetOrgPerson)(|({0}=*{1}*)({2}=*{3}*)))");
        ldapConfig.setQueryGroupsForUser("(&(objectClass=groupOfUniqueNames)(uniqueMember={0}))");

        ldapConfig.setUserIdAttribute("uid");
        ldapConfig.setUserFirstNameAttribute("cn");
        ldapConfig.setUserLastNameAttribute("sn");

        ldapConfig.setGroupIdAttribute("cn");
        ldapConfig.setGroupNameAttribute("cn");

        return ldapConfig;
    }
}