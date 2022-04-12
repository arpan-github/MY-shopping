package com.cloud.myShoppingBackend.config;

import java.util.Properties;

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
@ComponentScan(basePackages = { "com.cloud.myShopping.controller" })
public class HibernateConfiguration 
{
	
	private String DATABASE_URL="jdbc:h2:~/test";
	private String DATABASE_dRIVER="org.h2.Driver";
	private String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private String DATABASE_USERNAME="sa";
	private String DATABASE_PASSWORD="arpandash2password";
	
	@Bean
	public BasicDataSource getDataSource(){
		
		BasicDataSource bds = new BasicDataSource();
		
		bds.setDriverClassName(DATABASE_dRIVER);
		bds.setUrl(DATABASE_URL);
		bds.setUsername(DATABASE_USERNAME);
		bds.setPassword(DATABASE_PASSWORD);
		
		return bds;
	}
	@Bean
	public SessionFactory getSessionFactory(javax.sql.DataSource dataSourse) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder (dataSourse);
		builder.addProperties(getHibernatePropeeties());
		builder.scanPackages("com.niit.hibernateProject");
		
		return builder.buildSessionFactory();
		
	}

	private Properties getHibernatePropeeties() {
		
		Properties properties=new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		
		return properties;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory SessionFactory) {
		
		 HibernateTransactionManager htm = new HibernateTransactionManager(SessionFactory);
		
		return htm;
		
	}
}