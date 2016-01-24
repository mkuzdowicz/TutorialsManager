package org.kuzdowicz.repoapps.tutorials.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		driverManagerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.user"));
		driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return driverManagerDataSource;
	}

	private Properties hibernateProps() {

		Properties hbnProps = new Properties();
		hbnProps.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		hbnProps.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		hbnProps.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		/*
		 * AUTOMATIC CREATE DB SHCEMA AT RUNTIME
		 */
		hbnProps.setProperty("hibernate.hbm2ddl.auto", "create");
		
		return hbnProps;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProps());
		sessionFactory.setPackagesToScan(new String[] { "org.kuzdowicz.repoapps.tutorials.model" });

		return sessionFactory;

	}

	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sFactory) {

		HibernateTransactionManager tsxManager = new HibernateTransactionManager();
		tsxManager.setSessionFactory(sFactory);

		return tsxManager;

	}

}
