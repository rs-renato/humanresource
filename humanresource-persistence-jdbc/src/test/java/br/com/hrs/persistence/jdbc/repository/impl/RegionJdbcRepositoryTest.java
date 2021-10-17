package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.RegionRepository;
import br.com.hrs.persistence.jdbc.config.JdbcRepositoryTest;
import br.com.hrs.persistence.jpa.repository.RegionRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Region")
public class RegionJdbcRepositoryTest extends RegionRepositoryTest implements JdbcRepositoryTest {

    @Inject
    private RegionRepository regionJdbcRepository;

    @Override
    protected RegionRepository getRegionRepository() {
        return regionJdbcRepository;
    }
}