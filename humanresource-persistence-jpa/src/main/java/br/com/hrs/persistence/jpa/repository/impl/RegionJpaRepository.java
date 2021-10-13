package br.com.hrs.persistence.jpa.repository.impl;


import br.com.hrs.core.common.error.Error;
import br.com.hrs.core.common.error.FIELD;
import br.com.hrs.core.model.Region;
import br.com.hrs.core.repository.RegionRepository;
import br.com.hrs.persistence.jpa.repository.JpaRepositoryAbstractImpl;
import br.com.hrs.persistence.jpa.repository.JpaRepositoryContainer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;
import java.util.Optional;

@Named
public class RegionJpaRepository extends JpaRepositoryAbstractImpl<Region, Integer> implements RegionRepository {

    private JpaRepositoryContainer.RegionSpringDataJpaRepositoryImpl jpaRepository;

    @Inject
    public RegionJpaRepository(JpaRepositoryContainer.RegionSpringDataJpaRepositoryImpl jpaRepository) {
        super(jpaRepository);
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Region> findByName(String name) {
        logger.debug("findByName({}})", name);

        if (Objects.isNull(name)) {
            Error.of("Region Name").when(FIELD.MANDATORY).trows();
        }

        return this.jpaRepository.findByName(name);
    }
}