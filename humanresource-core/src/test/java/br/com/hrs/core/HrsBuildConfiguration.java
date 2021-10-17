package br.com.hrs.core;


import br.com.hrs.core.common.config.annotation.EnableHrsCore;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableHrsCore(loadMockRepository = true)
public class HrsBuildConfiguration {
    // Development Build : Unit Test  -> Core <-  Mocks
}