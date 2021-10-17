package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.CountryRepository;
import br.com.hrs.persistence.jpa.config.JpaRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Country")
public class CountryJpaRepositoryTest extends CountryRepositoryTest implements JpaRepositoryTest {

    @Inject
    private CountryRepository countryJpaRepository;

    @Override
    public CountryRepository getCountryRepository() {
        return this.countryJpaRepository;
    }
}