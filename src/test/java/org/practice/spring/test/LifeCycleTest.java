package org.practice.spring.test;

import org.junit.jupiter.api.Test;
import org.practice.spring.ioc_xml.BeanLife;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    @Test
    public void testLifeCycle() {
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring-lifecycle.xml");
//        ioc container close function need to call the subinterface "ConfigurableApplicationContext" or else of ApplicationContext.
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring-lifecycle.xml");
        BeanLife bean = ioc.getBean(BeanLife.class);
        System.out.println(bean);
        ioc.close();
    }
}
