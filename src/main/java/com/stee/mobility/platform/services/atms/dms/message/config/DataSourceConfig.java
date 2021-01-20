package com.stee.mobility.platform.services.atms.dms.message.config;

import com.stee.mobility.platform.services.atms.dms.message.constant.DataSourceType;
import com.stee.mobility.platform.services.atms.dms.message.router.DynamicDataSourceRouter;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 * @Class Name DataSourceConfig
 * @Desc 同步消息需要从SqlServer读取数据, 然后写入Mysql.所以需要2个数据源
 * @create: 2021-01-18 09:49
 **/
@Configuration
public class DataSourceConfig {

    SqlServerConfig sqlServerConfig;


    MysqlConfig mysqlConfig;


    public DataSource mysqlDataSourceConfig() {
        return new HikariDataSource(mysqlConfig);
    }

    public DataSource sqlServerDataSourceConfig() {
        return new HikariDataSource(sqlServerConfig);

    }


    @Bean
    @Primary
    public DataSource dataSource() {
        DynamicDataSourceRouter dynamicDataSourceRouter = new DynamicDataSourceRouter();
        DataSource mysqlSource = mysqlDataSourceConfig();
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceType.SQL_SERVER, sqlServerDataSourceConfig());
        dataSourceMap.put(DataSourceType.MYSQL, mysqlSource);

        // Set master datasource as default
        dynamicDataSourceRouter.setDefaultTargetDataSource(mysqlSource);
        // Set master and slave datasource as target datasource
        dynamicDataSourceRouter.setTargetDataSources(dataSourceMap);
        return dynamicDataSourceRouter;

    }


    @Autowired
    public void setSqlServerConfig(SqlServerConfig sqlServerConfig) {
        this.sqlServerConfig = sqlServerConfig;
    }

    @Autowired
    public void setMysqlConfig(MysqlConfig mysqlConfig) {
        this.mysqlConfig = mysqlConfig;
    }

}
