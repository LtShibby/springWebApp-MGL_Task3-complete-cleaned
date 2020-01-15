package com.MGL_Task3.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.MGL_Task3")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();

	dataSource.setDriverClassName(env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_DATABASE_DRIVER));
	dataSource.setUrl(env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_DATABASE_URL));
	dataSource.setUsername(env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_DATABASE_USERNAME));
	dataSource.setPassword(env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_DATABASE_PASSWORD));

	return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	sessionFactoryBean.setDataSource(dataSource());
	sessionFactoryBean.setPackagesToScan(
		env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
	sessionFactoryBean.setHibernateProperties(hibProperties());
	return sessionFactoryBean;
    }

    private Properties hibProperties() {
	Properties properties = new Properties();
	properties.put(HibernateConfiguration.PROPERTY_NAME_HIBERNATE_DIALECT,
		env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_HIBERNATE_DIALECT));
	properties.put(HibernateConfiguration.PROPERTY_NAME_HIBERNATE_SHOW_SQL,
		env.getRequiredProperty(HibernateConfiguration.PROPERTY_NAME_HIBERNATE_SHOW_SQL));
	return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	transactionManager.setSessionFactory(sessionFactory().getObject());
	return transactionManager;
    }
}