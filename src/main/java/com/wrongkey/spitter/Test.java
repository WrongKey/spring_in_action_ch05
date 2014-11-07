package com.wrongkey.spitter;

import com.wrongkey.spitter.DAO.JdbcTemplatePersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@author wrongkey
 *@description
 *@date 2014/11/6
 *@version v1.0
 *
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com.wrongkey.spitter/spitter.xml");
//        PersonDaoIpml personDaoIpml = (PersonDaoIpml)ctx.getBean("persondaoipml");
//        Person person = personDaoIpml.getPersonById(1);
//        System.out.println(person);
//        Person person1 = new Person();
//        person1.setId(2);
//        person1.setFirstName("wrong");
//        person1.setLastName("key");
//        person1.setAddress("chenglong Avenue 1819");
//        person1.setCity("Chengdu");
//
//        personDaoIpml.addPerson(person1);
//        person1.setAddress("Chenglong Avenue 1819");
//        personDaoIpml.savePerson(person1);
        JdbcTemplatePersonImpl jdbcTemplatePerson = (JdbcTemplatePersonImpl)ctx.getBean("jdbcTemplatePersonImpl");
        Person person = jdbcTemplatePerson.getPersonById(1);
        System.out.println(person);
        Person person1 = new Person();
        person1.setId(3);
        person1.setFirstName("hu");
        person1.setLastName("kai");
        person1.setAddress("chenglong Avenue 1819");
        person1.setCity("Chengdu Sichuan");

        jdbcTemplatePerson.addPerson(person1);
    }
}
