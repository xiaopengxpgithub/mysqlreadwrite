package com.atguigu.mysqlrw.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切换数据源(在dao方法执行之前执行)
 */
public class CustomDynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 根据这个方法的返回值确定使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return HandlerDataSource.getDataSource();
    }
}
