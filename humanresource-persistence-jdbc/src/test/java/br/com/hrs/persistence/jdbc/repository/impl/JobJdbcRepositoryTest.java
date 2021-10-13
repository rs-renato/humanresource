package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.JobRepository;
import br.com.hrs.persistence.jdbc.config.HrsJdbcConfiguration;
import br.com.hrs.persistence.jpa.repository.JobRepositoryTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Job")
@ContextConfiguration(classes = HrsJdbcConfiguration.class)
@ExtendWith(SpringExtension.class)
public class JobJdbcRepositoryTest extends JobRepositoryTest {

    @Inject
    private JobRepository jobJdbcRepository;

    @Override
    protected JobRepository getJobRepository() {
        return jobJdbcRepository;
    }
}