package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.JobRepository;
import br.com.hrs.persistence.jdbc.config.JdbcRepositoryTest;
import br.com.hrs.persistence.jpa.repository.JobRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Job")
public class JobJdbcRepositoryTest extends JobRepositoryTest implements JdbcRepositoryTest {

    @Inject
    private JobRepository jobJdbcRepository;

    @Override
    protected JobRepository getJobRepository() {
        return jobJdbcRepository;
    }
}