package com.stee.mobility.platform.services.atms.dms.message.holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Class Name DataSourceHolder
 * @Desc  为每一个线程保存自己的dataSource名字
 * @create: 2021-01-18 10:29
 **/
public class DataSourceHolder {
    private static Logger log = LoggerFactory.getLogger(DataSourceHolder.class);
    /**
     * 线程本地环境
     */
    private static final ThreadLocal<String> DATA_SOURCE = new ThreadLocal<String>();

    /**
     * 设置数据源
     */

    public static void setDataSource(String customerType) {
        log.info("Change to {} data source.", customerType);
        DATA_SOURCE.set(customerType);
    }

    /**
     * 获取数据源名字
     *
     * @return 数据源名字
     */
    public static String getDataSource() {
        return DATA_SOURCE.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        DATA_SOURCE.remove();
    }
}
