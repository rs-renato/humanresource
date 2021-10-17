package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.EmployeeRepository;
import br.com.hrs.persistence.jpa.config.JpaRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Employee")
public class EmployeeJpaRepositoryTest extends EmployeeRepositoryTest  implements JpaRepositoryTest {

    @Inject
    private EmployeeRepository employeeJpaRepository;

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return this.employeeJpaRepository;
    }
}