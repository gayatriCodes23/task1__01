package com.concerto.demo1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @AfterReturning(pointcut = "execution(* com.concerto.demo1.controller.TestController.*(..))", returning = "result")
//    public void logMethodCall(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        logger.info("Method '{}' returned: {}", methodName, result);
//    }
//    
//    
//    @AfterThrowing(pointcut = "execution(* com.concerto.demo1.*.*.*(..))", throwing = "exception")
//    public void handleException(JoinPoint joinPoint, Exception exception) {
//        String methodName = joinPoint.getSignature().getName();
//        logger.error("Method '{}' threw an exception: {}", methodName, exception.getMessage());
//        // You can add additional error handling logic here if needed
//    }
    
    

    // Define the pointcut for methods within com.concerto.demo1.controller.TestController
    @Pointcut("execution(* com.concerto.demo1.controller.TestController.*(..))")
    public void testControllerMethods() {
    }

    // AfterReturning advice for successful method execution
    @AfterReturning(pointcut = "testControllerMethods()", returning = "result")
    public void logMethodCall(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method '{}' returned: {}", methodName, result);
    }

    // AfterThrowing advice for handling exceptions
    @AfterThrowing(pointcut = "execution(* com.concerto.demo1.*.*.*(..))", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Method '{}' threw an exception: {}", methodName, exception.getMessage());
        // You can add additional error handling logic here if needed
    }
}
    

