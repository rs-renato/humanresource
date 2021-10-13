package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.LocationRepository;
import br.com.hrs.persistence.jpa.config.HrsJpaConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Location")
@ContextConfiguration(classes = HrsJpaConfiguration.class)
@ExtendWith(SpringExtension.class)
public class LocationJpaRepositoryTest extends LocationRepositoryTest {

    @Inject
    private LocationRepository locationJpaRepository;

    @Override
    protected LocationRepository getLocationRepository() {
        return locationJpaRepository;
    }
}