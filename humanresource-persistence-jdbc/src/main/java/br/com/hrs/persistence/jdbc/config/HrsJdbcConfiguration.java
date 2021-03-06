package br.com.hrs.persistence.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan(HrsJdbcConfiguration.PERSISTENCE_JDBC_REPOSITORY_PACKAGE)
public class HrsJdbcConfiguration {

    public static final String PERSISTENCE_JDBC_REPOSITORY_PACKAGE = "br.com.hrs.persistence.jdbc.repository.impl";

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource hrsDataSource) {
        return new JdbcTemplate(hrsDataSource);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource hrsDataSource) {
        return new DataSourceTransactionManager(hrsDataSource);
    }
}