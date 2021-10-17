package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.EmployeeRepository;
import br.com.hrs.persistence.jdbc.config.JdbcRepositoryTest;
import br.com.hrs.persistence.jpa.repository.EmployeeRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Employee")
public class EmployeeJdbcRepositoryTest extends EmployeeRepositoryTest implements JdbcRepositoryTest {

    @Inject
    private EmployeeRepository employeeJdbcRepository;

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return this.employeeJdbcRepository;
    }
}