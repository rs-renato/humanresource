package br.com.hrs.persistence;

import br.com.hrs.persistence.jpa.config.HrsJpaConfiguration;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages(HrsJpaConfiguration.PERSISTENCE_JPA_REPOSITORY_PACKAGE)
@SuiteDisplayName("HRS Persistence JPA Suite Test")
public class HrsPersistenceJpaSuitTest {

}