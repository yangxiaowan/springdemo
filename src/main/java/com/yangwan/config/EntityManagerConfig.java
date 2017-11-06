package com.yangwan.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory",transactionManagerRef="primaryTransactionManager",basePackages="com.yangwan.domain")
public class EntityManagerConfig
{
  @Autowired
  private DataSource dataSource;
  
  @Primary
  @Bean(name = "primaryEntityManager")
  public EntityManager primary(EntityManagerFactoryBuilder builder) {
      return primaryEntityManagerFactory(builder).getObject().createEntityManager();
  }
	
  @Primary
  @Bean(name = "primaryTransactionManager")
  public PlatformTransactionManager primaryTransactionManage(EntityManagerFactoryBuilder builder) {
      return new JpaTransactionManager(primaryEntityManagerFactory(builder).getObject());
  }
	
	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = builder.dataSource(dataSource).persistenceUnit("persistenceUnit").build();
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.implicit_naming_strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
		jpaProperties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
		jpaProperties.put("hibernate.connection.charSet", "utf-8");
		jpaProperties.put("hibernate.show_sql", "true");
		entityManagerFactory.setJpaProperties(jpaProperties);
		return entityManagerFactory;
	}
}
