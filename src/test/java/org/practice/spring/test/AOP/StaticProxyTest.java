package org.practice.spring.test.AOP;

import org.junit.jupiter.api.Test;
import org.practice.spring.proxy.CalculatorImpl;
import org.practice.spring.proxy.CalculatorStaticProxy;

public class StaticProxyTest {

    @Test
    public void testStaticProxy() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        int add = proxy.add(1, 2);
        System.out.println("add: " + add);

        int sub = proxy.sub(4, 1);
        System.out.println("sub: " + sub);

        int mul = proxy.mul(3, 5);
        System.out.println("mul: " + mul);

        int div = proxy.div(9, 3);
        System.out.println("div: " + div);
    }
}
