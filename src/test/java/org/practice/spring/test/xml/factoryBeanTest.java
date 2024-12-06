package org.practice.spring.test.xml;

import org.junit.jupiter.api.Test;
import org.practice.spring.ioc_xml.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class factoryBeanTest {
    @Test
    public void testFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("old/spring-factory.xml");
        Student bean = ioc.getBean(Student.class);
        System.out.println(bean);
    }
}
