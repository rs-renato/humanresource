package br.com.hrs.persistence.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@ComponentScan(HrsJpaConfiguration.PERSISTENCE_JPA_REPOSITORY_PACKAGE)
@EnableJpaRepositories(basePackages = HrsJpaConfiguration.PERSISTENCE_JPA_REPOSITORY_PACKAGE, considerNestedRepositories = true, enableDefaultTransactions = false, transactionManagerRef = "jpaTransactionManager")
@EnableTransactionManagement(proxyTargetClass = true)
public class HrsJpaConfiguration {

    public static final String PERSISTENCE_JPA_REPOSITORY_PACKAGE = "br.com.hrs.persistence.jpa.repository";

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.DERBY);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        return vendorAdapter;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource hrsDataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(hrsDataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(hibernateJpaProperties());
//        factoryBean.setPackagesToScan("br.com.hrs.service.repository.jpa.entity");
        factoryBean.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factoryBean.setMappingResources(getJpaResourceNames());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory hrsEntityManagerFactory) {
        return new JpaTransactionManager(hrsEntityManagerFactory);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor annotationBean() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    private Properties hibernateJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.bytecode.use_reflection_optimizer", "true");
        properties.setProperty("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.jcache.JCacheRegionFactory");
        properties.setProperty("hibernate.cache.provider_configuration_file_resource_path", "/ehcache.xml");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return properties;
    }

    private String[] getJpaResourceNames() {
        try {
            String relativeFolder = "jpa";

            String path = "classpath:" + relativeFolder + "/*-orm.xml";

            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(path);
            return Arrays.stream(resources)
                    .map(resource -> {
                        try {
                            return relativeFolder + "/" + resource.getFilename();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toList())
                    .toArray(new String[resources.length]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}