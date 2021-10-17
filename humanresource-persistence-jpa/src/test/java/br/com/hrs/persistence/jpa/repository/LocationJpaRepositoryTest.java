package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.LocationRepository;
import br.com.hrs.persistence.jpa.config.JpaRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Location")
public class LocationJpaRepositoryTest extends LocationRepositoryTest  implements JpaRepositoryTest {

    @Inject
    private LocationRepository locationJpaRepository;

    @Override
    protected LocationRepository getLocationRepository() {
        return locationJpaRepository;
    }
}