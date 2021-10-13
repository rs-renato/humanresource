package br.com.hrs.persistence.jpa.repository.impl;


import br.com.hrs.core.model.Job;
import br.com.hrs.core.repository.JobRepository;
import br.com.hrs.persistence.jpa.repository.JpaRepositoryAbstractImpl;
import br.com.hrs.persistence.jpa.repository.JpaRepositoryContainer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class JobJpaRepository extends JpaRepositoryAbstractImpl<Job, String> implements JobRepository {

    private JpaRepositoryContainer.JobSpringDataJpaRepositoryImpl jpaRepository;

    @Inject
    public JobJpaRepository(JpaRepositoryContainer.JobSpringDataJpaRepositoryImpl jpaRepository) {
        super(jpaRepository);
        this.jpaRepository = jpaRepository;
    }
}