package org.practice.spring.test;

import org.junit.jupiter.api.Test;
import org.practice.spring.ioc_xml.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCByXMLtest {
    @Test
    public void setterTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = ioc.getBean("student",Student.class);
        System.out.println(bean);
    }

    @Test
    public void constructorTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = ioc.getBean("studentConstructor", Student.class);
        System.out.println(bean);
    }

    @Test
    public void constructorSpecificValueTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = ioc.getBean("studentConstructorSpecificValue", Student.class);
        System.out.println(bean);
    }

    @Test
    public void studentWithClassTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = ioc.getBean("studentWithClass", Student.class);
        System.out.println(bean);
    }

    @Test
    public void studentWithClassOneTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = ioc.getBean("studentWithClassOne", Student.class);
        System.out.println(bean);
    }

    @Test
    public void studentWithClassTwoTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = ioc.getBean("studentWithClassTwo", Student.class);
        System.out.println(bean);
    }
}
