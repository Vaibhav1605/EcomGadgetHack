package com.ecom.ecombackend.configuaration;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecom.ecombackend")
public class HibConfig {

	@Bean(name = { "dataSource" })
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecom");
		dataSource.setUsername("vai");
		dataSource.setPassword("vai");

		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource());
		localSessionFactoryBuilder.scanPackages("com.ecom.ecombackend");
		localSessionFactoryBuilder.addProperties(hibernateProperties());
		return localSessionFactoryBuilder.buildSessionFactory();
	}

	public Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate_format_sql", "true");
		hibernateProperties.put("hibernate.show_sql", "org.hibernate.SQL");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		return hibernateProperties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

}
