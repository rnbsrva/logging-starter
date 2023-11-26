package com.akerke.loggingstarter.common.aspect;

import com.akerke.loggingstarter.model.ExecutionTimeLog;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;


/**
 * Aspect for logging the execution time of methods annotated with {@link com.akerke.loggingstarter.common.annotation.EnableLoggerLib}.
 */
@Aspect
@RequiredArgsConstructor
public class EnableLoggerLibTimeExecutionAspect {

    private final static Logger logger = LoggerFactory.getLogger(EnableLoggerLibTimeExecutionAspect.class);

    /**
     * Logs the execution time of methods annotated with {@link com.akerke.loggingstarter.common.annotation.EnableLoggerLib}.
     *
     * @param pjp the proceeding join point representing the intercepted method
     * @return the result of the intercepted method
     * @throws Throwable if an error occurs during method execution
     */
    @Around("@within(com.akerke.loggingstarter.common.annotation.EnableLoggerLib)")
    public Object logMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        var methodSignature = (MethodSignature) pjp.getSignature();

        final var stopWatch = new StopWatch();

        stopWatch.start();
        var result = pjp.proceed();
        stopWatch.stop();

        var executionTimeLog = ExecutionTimeLog
                .builder()
                .method(methodSignature.getName())
                .execution(stopWatch.getLastTaskTimeMillis())
                .className(methodSignature.getDeclaringType().getSimpleName())
                .build();

        logger.info("Log {}", executionTimeLog);

        return result;
    }
}
