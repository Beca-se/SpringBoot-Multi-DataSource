package com.stee.mobility.platform.services.atms.dms.message.router;

import com.stee.mobility.platform.services.atms.dms.message.holder.DataSourceHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Administrator
 * @Class Name DynamicDataSourceRouter
 * @Desc 切换不同数据源的核心类
 * @create: 2021-01-18 10:37
 **/

public class DynamicDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }


}