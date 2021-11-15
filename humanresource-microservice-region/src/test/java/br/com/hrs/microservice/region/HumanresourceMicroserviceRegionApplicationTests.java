package br.com.hrs.microservice.region;

import br.com.hrs.core.common.config.annotation.EnableHrsCore;
import br.com.hrs.persistence.config.HrsMemoryDatasource;
import br.com.hrs.persistence.jdbc.config.annotation.EnableHrsJdbcPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@EnableHrsCore
@EnableHrsJdbcPersistence
@SpringBootTest(classes= HrsMemoryDatasource.class)
class HumanresourceMicroserviceRegionApplicationTests {

    @Test
    void contextLoads() {
    }

}
