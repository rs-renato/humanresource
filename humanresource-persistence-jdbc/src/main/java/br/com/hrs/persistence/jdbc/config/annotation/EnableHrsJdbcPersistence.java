package br.com.hrs.persistence.jdbc.config.annotation;

import br.com.hrs.persistence.jdbc.config.HrsJdbcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Configuration
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Import(HrsJdbcPersistenceConfigurationSelector.class)
public @interface EnableHrsJdbcPersistence {
    Class[] classes() default HrsJdbcConfiguration.class;
}