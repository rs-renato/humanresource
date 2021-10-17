package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.CountryRepository;
import br.com.hrs.persistence.jdbc.config.JdbcRepositoryTest;
import br.com.hrs.persistence.jpa.repository.CountryRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Country")
public class CountryJdbcRepositoryTest extends CountryRepositoryTest implements JdbcRepositoryTest {

    @Inject
    private CountryRepository countryJdbcRepository;

    @Override
    public CountryRepository getCountryRepository() {
        return this.countryJdbcRepository;
    }
}