package br.com.hrs.microservice.region.config;

import br.com.hrs.core.common.config.annotation.EnableHrsCore;
import br.com.hrs.persistence.jdbc.config.annotation.EnableHrsJdbcPersistence;
import com.hrs.microservice.config.HrsApiSwaggerConfiguration;
import com.hrs.microservice.config.HrsApiWebMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableHrsCore
@EnableHrsJdbcPersistence
public class HrsApiInfraConfiguration {

    @Configuration
    @Import(HrsApiWebMvcConfiguration.class)
    public static class HrsRegionWebMcvConfiguration{
    }

    @Configuration
    @Import(HrsApiSwaggerConfiguration.class)
    public static class HrsRegionSwaggerConfiguration{
    }

}
