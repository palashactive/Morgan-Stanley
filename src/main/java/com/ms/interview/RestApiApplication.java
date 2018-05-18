package com.ms.interview;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
	    final PGSimpleDataSource dataSource = new PGSimpleDataSource();

	    dataSource.setDatabaseName( "postgres" );
	    dataSource.setUser( "postgres" );
	    dataSource.setPassword("tiger");

	    return dataSource;
	}

	@Bean
	public Properties hibernateProperties(){
	    final Properties properties = new Properties();

	    properties.put( "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect" );
	    properties.put( "hibernate.connection.driver_class", "org.postgresql.Driver" );

	    return properties;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory( DataSource dataSource, Properties hibernateProperties ){
	    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource( dataSource );
	    em.setPackagesToScan( "com.ms.interview" );
	    em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
	    em.setJpaProperties( hibernateProperties );
	    em.setPersistenceUnitName( "punit" );
	    em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	    em.afterPropertiesSet();

	    return em.getObject();
	}
}
