package br.com.hrs.persistence.jpa.repository;

import br.com.hrs.core.repository.DepartmentRepository;
import br.com.hrs.persistence.jpa.config.JpaRepositoryTest;
import org.junit.jupiter.api.DisplayName;

import javax.inject.Inject;

@DisplayName("Jpa Repository - Department")
public class DepartmentJpaRepositoryTest extends DepartmentRepositoryTest implements JpaRepositoryTest{

    @Inject
    private DepartmentRepository departmentJpaRepository;

    @Override
    protected DepartmentRepository getDepartmentRepository() {
        return departmentJpaRepository;
    }
}