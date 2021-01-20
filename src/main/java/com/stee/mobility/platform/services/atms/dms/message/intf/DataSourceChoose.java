package com.stee.mobility.platform.services.atms.dms.message.intf;

import com.stee.mobility.platform.services.atms.dms.message.constant.DataSourceType;

import java.lang.annotation.*;

/**
 * @author Administrator
 * @Class Name DataSourceType
 * @Desc 自定义注解, 只能用于方法上, 切换数据源时候使用
 * @create: 2021-01-18 09:58
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface DataSourceChoose {

    String value() default DataSourceType.MYSQL;
}
