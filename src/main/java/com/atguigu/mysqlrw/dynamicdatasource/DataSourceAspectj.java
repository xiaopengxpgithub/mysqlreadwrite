package com.atguigu.mysqlrw.dynamicdatasource;

import com.atguigu.mysqlrw.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * aop切面类,对service方法进行增强
 * 当前用户访问请求与我们的数据源的字符串建立映射关系
 */
@Component
@Aspect
@Order(-1)
public class DataSourceAspectj {

    private static final Logger logger=LoggerFactory.getLogger(DataSourceAspectj.class);

    @Before(value = "execution(* com.atguigu.mysqlrw.service..*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("before annotation 方法增强启动!");

        Object target = joinPoint.getTarget();

        // service方法名称
        String targetMethodName = joinPoint.getSignature().getName();

        // 获取aop代理的接口
        Class<?>[] interfaceszz = target.getClass().getInterfaces();

        Class<?>[] parameterTypezz = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();

        for (Class<?> interfacezz : interfaceszz) {
            try {
                // 接口方法
                Method intfMethod = interfacezz.getMethod(targetMethodName, parameterTypezz);

                if (intfMethod != null) {
                    // service接口方法的注解不为空
                    if (intfMethod.isAnnotationPresent(TargetDataSource.class)) {
                        TargetDataSource targetDataSource = intfMethod.getAnnotation(TargetDataSource.class);

                        // 这个就是建立当前请求线程与service方法注解的数据源字符串的映射
                        // 动态的将service方法的注解的字符串存储到本地线程容器中
                        HandlerDataSource.putDataSource(targetDataSource.value());
                    } else {
                        //service接口方法没有添加注解,那么就就他一个默认的数据源
                        HandlerDataSource.putDataSource("read");
                    }
                } else {
                    continue;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
