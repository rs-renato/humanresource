package br.com.hrs.persistence.jdbc.config;

import br.com.hrs.persistence.config.HrsMemoryDatasourceConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HrsJdbcConfiguration.class, HrsMemoryDatasourceConfig.class})
@ExtendWith(SpringExtension.class)
public interface JdbcRepositoryTest { }