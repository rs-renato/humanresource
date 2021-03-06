package br.com.hrs.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class HrsMemoryDatasourceConfig {

    @Bean
    public DataSource hrsDataSource() {
        return new EmbeddedDatabaseBuilder()
                .addScript("database/create.sql")
                .addScript("database/insert.sql")
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.DERBY)
                .build();
    }
}
