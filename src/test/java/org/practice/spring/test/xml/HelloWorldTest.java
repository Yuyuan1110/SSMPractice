package org.practice.spring.test.xml;

import org.junit.jupiter.api.Test;
import org.practice.spring.helloworld.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:old/applicationContext.xml");
        HelloWorld bean = ioc.getBean(HelloWorld.class);
        bean.sayHello();
    }
}
