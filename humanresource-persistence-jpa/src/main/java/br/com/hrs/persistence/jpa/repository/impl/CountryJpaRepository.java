package br.com.hrs.persistence.jpa.repository.impl;


import br.com.hrs.core.common.error.Error;
import br.com.hrs.core.common.error.FIELD;
import br.com.hrs.core.model.Country;
import br.com.hrs.core.repository.CountryRepository;
import br.com.hrs.persistence.jpa.repository.JpaRepositoryAbstractImpl;
import br.com.hrs.persistence.jpa.repository.JpaRepositoryContainer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Named
public class CountryJpaRepository extends JpaRepositoryAbstractImpl<Country, String> implements CountryRepository {

    private JpaRepositoryContainer.CountrySpringDataJpaRepositoryImpl jpaRepository;

    @Inject
    public CountryJpaRepository(JpaRepositoryContainer.CountrySpringDataJpaRepositoryImpl jpaRepository) {
        super(jpaRepository);
        this.jpaRepository = jpaRepository;
    }

    public Optional<List<Country>> findByRegionId(Integer regionId) {
        logger.debug("findByRegionId({}})", regionId);

        if (Objects.isNull(regionId)) {
            Error.of("Region ID").when(FIELD.MANDATORY).trows();
        }

        return this.jpaRepository.findByRegionId(regionId);
    }
}