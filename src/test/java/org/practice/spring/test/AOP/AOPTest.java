package org.practice.spring.test.AOP;

import org.junit.jupiter.api.Test;
import org.practice.spring.aop.xml.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void testAOPByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("old/aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,1);
        bean.mul(2,10);
        bean.div(8,2);

    }
    @Test
    public void testAOPByXML() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("old/aop-xml.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,1);
        bean.mul(2,10);
        bean.div(8,2);

    }
}
