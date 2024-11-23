package org.practice.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object result = null;
                try {
                    System.out.println("logger, method: "+ method.getName()+", parameter: " + Arrays.toString(objects));
                    result = method.invoke(target, objects);
                    System.out.println("logger, method: "+ method.getName()+", result: " + result);
                } catch (Exception e) {
                    System.out.println("logger, method: "+ method.getName()+", exception: " + e);
                    e.printStackTrace();
                } finally {
                    System.out.println("method done!");
                }
                return result;
            }
        });
    }
}
