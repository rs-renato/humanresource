package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.JobRepository;
import br.com.hrs.persistence.jpa.config.JpaRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Job")
public class JobJpaRepositoryTest extends JobRepositoryTest implements JpaRepositoryTest {

    @Inject
    private JobRepository jobJpaRepository;

    @Override
    protected JobRepository getJobRepository() {
        return jobJpaRepository;
    }
}