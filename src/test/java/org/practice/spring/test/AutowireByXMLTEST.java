package org.practice.spring.test;

import org.junit.jupiter.api.Test;
import org.practice.spring.ioc_xml.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTEST {
    @Test
    public void testAutowireByXML() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        StudentController bean = ioc.getBean(StudentController.class);
        bean.saveStudent();
    }
}
