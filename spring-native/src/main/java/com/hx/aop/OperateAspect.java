package com.hx.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kyle
 */
@Aspect
@Configuration
public class OperateAspect {

    /**
     * 1 定义切点
     *
     * 2 切点逻辑
     *
     * 3 置入（Spring完成）
     *
     */

    private ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(
            1, 1 , 1, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(10)
    );

    @Pointcut("@annotation(com.hx.aop.RecordOperate)")
    public void pointcut() {
    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = proceedingJoinPoint.proceed();
        threadExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
                RecordOperate annotation = signature.getMethod().getAnnotation(RecordOperate.class);
                String desc = annotation.desc();
                OperationLogDO operationLogDO = new OperationLogDO();
                operationLogDO.setDesc(desc);
                operationLogDO.setLocalDateTime(LocalDateTime.now());


                Class<? extends Convert> convert = annotation.convert();
                Convert convert1 = convert.newInstance();
                OperationLogDO operationLogDOV1 = convert1.convert(proceedingJoinPoint.getArgs()[0]);
                operationLogDOV1.setDesc(desc);
                operationLogDOV1.setLocalDateTime(LocalDateTime.now());
                System.out.println("保存DO:, " + operationLogDOV1);

            }
        });
        return proceed;
    }

}
