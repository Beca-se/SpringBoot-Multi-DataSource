package com.stee.mobility.platform.services.atms.dms.message.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @Class Name SqlServerConfig
 * @Desc Mysql数据源配置信息, 使用的HikariDataSource连接池
 * @create: 2021-01-18 11:27
 **/
@ConfigurationProperties(prefix = "spring.datasource.sqlserver")
@Configuration
public class SqlServerConfig extends HikariConfig {

}
