package com.edhaut.mysql.config;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactory",
		basePackages = {"com.edhaut.mysql.repository"},
		transactionManagerRef = "transactionManager"
		)

public class MySqlDbConfig {
	
	@Autowired
	private Environment env;
	
	//dataSource
	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(env.getProperty("spring.datasource.mysql.jdbcUrl"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.mysql.driver-class-name"));
		dataSource.setUsername(env.getProperty("spring.datasource.mysql.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.mysql.password"));
	
		
		return dataSource;
	}
	
	//entityManagerFactory
	@Bean(name="entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		
		bean.setDataSource(dataSource());
		
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		
		bean.setPackagesToScan("com.edhaut.mysql.entity");
		
		Map<String,String> props = new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		bean.setJpaPropertyMap(props);
		
		return bean;
		
	}
	
	//platformtransactionManager
	@Primary
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}

}
