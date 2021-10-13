package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.EmployeeRepository;
import br.com.hrs.persistence.jdbc.config.HrsJdbcConfiguration;
import br.com.hrs.persistence.jpa.repository.EmployeeRepositoryTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Employee")
@ContextConfiguration(classes = HrsJdbcConfiguration.class)
@ExtendWith(SpringExtension.class)
public class EmployeeJdbcRepositoryTest extends EmployeeRepositoryTest {

    @Inject
    private EmployeeRepository employeeJdbcRepository;

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return this.employeeJdbcRepository;
    }
}