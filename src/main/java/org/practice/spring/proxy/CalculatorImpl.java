package org.practice.spring.proxy;

public class CalculatorImpl  implements Calculator {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println("Inner function, result:"+result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        System.out.println("Inner function, result:"+result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        System.out.println("Inner function, result:"+result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        System.out.println("Inner function, result:"+result);
        return result;
    }
}
