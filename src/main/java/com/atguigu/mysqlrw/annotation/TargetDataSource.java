package com.atguigu.mysqlrw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解类,指定某个请求要操作的数据库
 */

@Retention(RetentionPolicy.RUNTIME) //该注解作用的时机
@Target(ElementType.METHOD) //该注解作用的范围
public @interface TargetDataSource {

    String value() default "";
}
