package com.boot.swagger.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "databaseEntityManagerFactory2", 
		transactionManagerRef = "databaseTransactionManager2",
		basePackages = {"com.boot.swagger.dao" })
public class DatabaseConfig_2 {

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "mysql2.datasource")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "databaseEntityManagerFactory2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource2") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.boot.swagger.dao").persistenceUnit("databaseUnit2").build();
	}

	@Bean(name = "databaseTransactionManager2")
	public PlatformTransactionManager transactionManager(
			@Qualifier("databaseEntityManagerFactory2") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
