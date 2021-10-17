package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.LocationRepository;
import br.com.hrs.persistence.jdbc.config.JdbcRepositoryTest;
import br.com.hrs.persistence.jpa.repository.LocationRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Location")
public class LocationJdbcRepositoryTest extends LocationRepositoryTest implements JdbcRepositoryTest {

    @Inject
    private LocationRepository locationJdbcRepository;

    @Override
    protected LocationRepository getLocationRepository() {
        return locationJdbcRepository;
    }
}