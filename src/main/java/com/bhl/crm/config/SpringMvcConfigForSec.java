package com.bhl.crm.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.bhl.crm")
@PropertySource("classpath:security-persistence-mysql.properties")
public class SpringMvcConfigForSec implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource dataSourceForUsers() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
			
			logger.info("\n=======>>> URL : "+ env.getProperty("security.jdbc.url"));
			logger.info("\n=======>>> USER : "+ env.getProperty("security.jdbc.user"));

			dataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
			dataSource.setUser(env.getProperty("security.jdbc.user"));
			dataSource.setPassword(env.getProperty("security.jdbc.password"));


			dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("security.connection.pool.initialPoolSize")));
			dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("security.connection.pool.minPoolSize")));
			dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("security.connection.pool.maxPoolSize")));
			dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("security.connection.pool.maxIdleTime")));
		} catch (PropertyVetoException e) {
			new RuntimeException(e);
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("security.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("security.hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBeanForUsers() {
		LocalSessionFactoryBean  sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSourceForUsers());
		sessionFactory.setPackagesToScan("com.bhl.crm.entities");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManagerForUsers() {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactoryBeanForUsers().getObject());
		return manager;
	}

//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
	
	
	
}
