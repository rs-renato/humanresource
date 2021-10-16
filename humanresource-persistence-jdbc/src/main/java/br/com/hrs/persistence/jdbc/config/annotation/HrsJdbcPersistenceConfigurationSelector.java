package br.com.hrs.persistence.jdbc.config.annotation;

import br.com.hrs.persistence.config.annotation.selector.HrsPersistenceConfigurationSelector;

import java.lang.annotation.Annotation;

public class HrsJdbcPersistenceConfigurationSelector extends HrsPersistenceConfigurationSelector {

    @Override
    public Class<? extends Annotation> getPersistenceConfigurationClass() {
        return EnableHrsJdbcPersistence.class;
    }
}

