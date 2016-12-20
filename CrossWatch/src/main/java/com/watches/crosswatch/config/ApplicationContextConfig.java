package com.watches.crosswatch.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.watches.crosswatch.model.Brand;
import com.watches.crosswatch.model.Category;
import com.watches.crosswatch.model.Product;
import com.watches.crosswatch.model.SubCategory;
import com.watches.crosswatch.model.Supplier;

@Configuration
@ComponentScan("com.watches.crosswatch")
@EnableTransactionManagement
public class ApplicationContextConfig {
	

	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/crosswatch");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        
        Properties dproperties = new Properties();
        dproperties.setProperty("hibernate.show_sql", "true");
        dproperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        dproperties.setProperty("hibernate.hbm2ddl.auto", "update");

        return dataSource;
    }
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;        
    }

	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) 
	{
		
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       return txManager;
    }
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory SessionFactory(DataSource dataSource) 
	{
	  
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(hibernateProperties());
	    sessionBuilder.addAnnotatedClass(Category.class);
	    sessionBuilder.addAnnotatedClass(Supplier.class);
	    sessionBuilder.addAnnotatedClass(SubCategory.class);
	    sessionBuilder.addAnnotatedClass(Brand.class);
	    sessionBuilder.addAnnotatedClass(Product.class);
	    
		return sessionBuilder.buildSessionFactory();
	}
}