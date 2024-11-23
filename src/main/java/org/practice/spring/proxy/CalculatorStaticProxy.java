package org.practice.spring.proxy;

public class CalculatorStaticProxy implements Calculator {

    public CalculatorStaticProxy(CalculatorImpl calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    private final CalculatorImpl calculatorImpl;
    @Override
    public int add(int a, int b) {
        int result = 0;
        try {
            System.out.println("Logger, Method: add, parameters: " + a + ", " + b);
            result = calculatorImpl.add(a, b);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = 0;
        try {
            System.out.println("Logger, Method: sub, parameters: " + a + ", " + b);
            result = calculatorImpl.sub(a, b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = 0;
        System.out.println("Logger, Method: mul, parameters: " + a + ", " + b);
        result = calculatorImpl.mul(a, b);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = 0;
        System.out.println("Logger, Method: div, parameters: " + a + ", " + b);
        result = calculatorImpl.div(a, b);
        return result;
    }
}
