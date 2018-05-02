package com.atguigu.mysqlrw.dynamicdatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 绑定数据源,根据用户提交的请求(最终执行的service方法)绑定对应的数据源
 */
public class HandlerDataSource {

    private static final Logger logger=LoggerFactory.getLogger(HandlerDataSource.class);

    // 本地线程变量,可以跟用户请求绑定
    // 针对当前请求,单独创建一个容器,存储当前线程的变量
    // 多个threadlocal之间互不影响
    public static final ThreadLocal<String> hodler = new ThreadLocal<String>();


    public static void putDataSource(String dataSource) {
        logger.info("当前数据源:" + dataSource);

        // 将请求对应的操作(service方法上的标识)保存到本地线程容器中,传递给动态数据源切换类
        hodler.set(dataSource);
    }

    // 动态数据源切换时获取当前请求对应的数据源
    public static String getDataSource() {
        return hodler.get();
    }
}
