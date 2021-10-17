package br.com.hrs.persistence.jdbc.repository.impl;

import br.com.hrs.core.repository.DepartmentRepository;
import br.com.hrs.persistence.jdbc.config.JdbcRepositoryTest;
import br.com.hrs.persistence.jpa.repository.DepartmentRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jdbc Repository - Department")
public class DepartmentJdbcRepositoryTest extends DepartmentRepositoryTest implements JdbcRepositoryTest {

    @Inject
    private DepartmentRepository departmentJdbcRepository;

    @Override
    protected DepartmentRepository getDepartmentRepository() {
        return departmentJdbcRepository;
    }
}