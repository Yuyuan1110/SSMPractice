package org.practice.spring.test;

import org.junit.jupiter.api.Test;
import org.practice.spring.helloworld.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HelloWorld bean = ioc.getBean(HelloWorld.class);
        bean.sayHello();
    }
}
