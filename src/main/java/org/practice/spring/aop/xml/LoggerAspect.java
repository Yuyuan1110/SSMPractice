package org.practice.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("before advice method: "+signature.getName()+"parameter :"+ Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("after advice method: after method is effect!");
    }
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {

        System.out.println("after returning advice method, result: "+result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        System.out.println("after throwing advice method!!! exception: "+ ex);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("There is before advice method");
            result = joinPoint.proceed();
            System.out.println("There is after returning advice method");
        } catch (Throwable e) {
            System.out.println("There is after throwing(exception) advice method");
            throw new RuntimeException(e);
        }finally {
            System.out.println("There is after advice method");
        }
        return result;
    }
}
