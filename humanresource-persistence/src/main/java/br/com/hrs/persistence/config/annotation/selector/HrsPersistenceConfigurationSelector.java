package br.com.hrs.persistence.config.annotation.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public abstract class HrsPersistenceConfigurationSelector implements ImportSelector {

    public abstract Class<? extends Annotation> getPersistenceConfigurationClass();

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(annotationMetadata.getAnnotationAttributes(getPersistenceConfigurationClass().getName(), false));

        return Stream
                .of(attributes.getClassArray("classes"))
                .map(Class::getName)
                .toArray(String[]::new);
    }
}

