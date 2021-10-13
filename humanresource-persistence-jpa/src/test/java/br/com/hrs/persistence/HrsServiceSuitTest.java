package br.com.hrs.persistence;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("br.com.hrs.persistence.repository")
@SuiteDisplayName("HRS Persistence JPA Suite Test")
public class HrsServiceSuitTest {

}