package com.lavax.utils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by LAVAX on 2017/12/15.
 */
public class LogAspect {
    public Object traceMethod(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnVal = null;
        //获取当前dao的全称
        final Logger log = getLog(proceedingJoinPoint);
        //获取当前dao类的执行方法
        final String methodName = proceedingJoinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        try {
            if (log.isInfoEnabled()) {
                final Object[] args = proceedingJoinPoint.getArgs();
                final String arguments;
                if (args == null || args.length == 0) {
                    arguments = "";
                } else {
                    arguments = Arrays.deepToString(args);
                }
                log.info("进入方法[" + methodName + "];参数[" + arguments + "]");
            }
            returnVal = proceedingJoinPoint.proceed();
            return returnVal;
        } finally {
            if (log.isInfoEnabled()) {
                log.info("离开方法 [" + methodName + "] ;返回值 [" + (returnVal != null ? returnVal.toString() : "null") + "].");
                long end = System.currentTimeMillis();
                log.info("执行方法耗时：" + (end - start) + "毫秒。");
            }
        }

    }

    protected Logger getLog(final JoinPoint joinPoint) {
        final Object target = joinPoint.getTarget();
        if (target != null) {
            return LoggerFactory.getLogger(target.getClass());
        }
        return LoggerFactory.getLogger(getClass());
    }
}
