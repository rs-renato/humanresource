package br.com.hrs.persistence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.name:}")
    private String name;

    @Value("${spring.datasource.driver-class-name:}")
    private String driver;

    @Value("${spring.datasource.type:}")
    private Class type;

    @Value("${spring.datasource.url:}")
    private String url;

    @Value("${spring.datasource.username:}")
    private String username;

    @Value("${spring.datasource.password:}")
    private String password;

    public DataSourceConfig() {
    }

    public DataSourceConfig(String name, String driver, Class type, String url, String username, String password) {
        this.name = name;
        this.driver = driver;
        this.type = type;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getDriver() {
        return driver;
    }

    public Class getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
