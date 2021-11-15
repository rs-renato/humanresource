package br.com.hrs.persistence.jdbc.config;

import br.com.hrs.persistence.config.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(HrsJdbcConfiguration.PERSISTENCE_JDBC_REPOSITORY_PACKAGE)
public class HrsJdbcConfiguration {

    public static final String PERSISTENCE_JDBC_REPOSITORY_PACKAGE = "br.com.hrs.persistence.jdbc.repository.impl";

    @Bean
    public DataSourceConfig dataSourceConfig(){
        return new DataSourceConfig();
    }

    @Bean
    public DataSource hrsDataSource(DataSourceConfig dataSourceConfig){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceConfig.getDriver());
        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUsername());
        dataSource.setPassword(dataSourceConfig.getPassword());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource hrsDataSource) {
        return new JdbcTemplate(hrsDataSource);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource hrsDataSource) {
        return new DataSourceTransactionManager(hrsDataSource);
    }
}