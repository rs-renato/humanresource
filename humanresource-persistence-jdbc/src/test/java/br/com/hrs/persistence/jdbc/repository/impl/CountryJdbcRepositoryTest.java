package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.CountryRepository;
import br.com.hrs.persistence.jdbc.config.HrsJdbcConfiguration;
import br.com.hrs.persistence.jpa.repository.CountryRepositoryTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Country")
@ContextConfiguration(classes = HrsJdbcConfiguration.class)
@ExtendWith(SpringExtension.class)
public class CountryJdbcRepositoryTest extends CountryRepositoryTest {

    @Inject
    private CountryRepository countryJdbcRepository;

    @Override
    public CountryRepository getCountryRepository() {
        return this.countryJdbcRepository;
    }
}