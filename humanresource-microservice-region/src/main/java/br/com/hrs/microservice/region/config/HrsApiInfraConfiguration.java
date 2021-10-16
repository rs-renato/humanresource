package br.com.hrs.microservice.region.config;

import br.com.hrs.core.common.config.annotation.EnableHrsCore;
import br.com.hrs.persistence.jdbc.config.annotation.EnableHrsJdbcPersistence;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHrsCore
@EnableHrsJdbcPersistence
public class HrsApiInfraConfiguration {

}
