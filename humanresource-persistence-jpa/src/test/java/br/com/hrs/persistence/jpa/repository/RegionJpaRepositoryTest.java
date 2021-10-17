package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.RegionRepository;
import br.com.hrs.persistence.jpa.config.JpaRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Region")
public class RegionJpaRepositoryTest extends RegionRepositoryTest  implements JpaRepositoryTest {

    @Inject
    private RegionRepository regionJpaRepository;

    @Override
    protected RegionRepository getRegionRepository() {
        return regionJpaRepository;
    }
}