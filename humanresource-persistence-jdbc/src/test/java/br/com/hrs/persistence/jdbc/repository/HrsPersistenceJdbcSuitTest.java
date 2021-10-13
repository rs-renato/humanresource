package br.com.hrs.persistence.jdbc.repository;

import br.com.hrs.persistence.jdbc.config.HrsJdbcConfiguration;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages(HrsJdbcConfiguration.PERSISTENCE_JDBC_REPOSITORY_PACKAGE)
@SuiteDisplayName("HRS Persistence JDBC Suite Test")
public class HrsPersistenceJdbcSuitTest {

}