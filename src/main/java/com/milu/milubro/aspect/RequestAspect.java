package com.milu.milubro.aspect;


import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class RequestAspect {

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object requestAsptect(final ProceedingJoinPoint joinPoint) throws Throwable {
        Class<?> tagertType = joinPoint.getTarget().getClass();
        //查看通知的签名
        Signature signature = joinPoint.getSignature();

        //根据签名获取其中的执行的方法
        String methodName = signature.getName();
         Method method = ((MethodSignature)signature).getMethod();
         method.getParameters();

        log.info("\n tagerType:"+tagertType.getName()+"\n className:"+tagertType.getSimpleName()+"\n methodName:"+methodName
        +"\n signature.getDeclaringTypeName:"+signature.getDeclaringTypeName()+"\n method:"+method.getName());
        return joinPoint.proceed();
    }
}
