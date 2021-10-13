package br.com.hrs.persistence.config.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class HrsPersistenceConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(annotationMetadata.getAnnotationAttributes(EnableHrsPersistence.class.getName(), false));

        return Stream
                .of(attributes.getClassArray("classes"))
                .map(Class::getName)
                .toArray(String[]::new);
    }
}

