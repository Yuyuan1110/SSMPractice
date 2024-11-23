package org.practice.spring.test.AOP;

import org.junit.jupiter.api.Test;
import org.practice.spring.proxy.Calculator;
import org.practice.spring.proxy.CalculatorImpl;
import org.practice.spring.proxy.ProxyFactory;

public class DynamicProxyTest {

//  jdk dynamic proxy
    @Test
    public void test() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy =(Calculator) proxyFactory.getProxy();
        proxy.div(1,0);
    }
}
