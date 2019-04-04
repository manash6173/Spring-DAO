package com.manash.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.manash.dao")
@PropertySource(value="classpath:/com/manash/commons/jdbc.properties")
public class PersistenceBeansConfig {
	@Autowired
	Environment env;
	@Bean
	public DataSource createDS() {
		HikariDataSource hkcp=null;
		//create data source class object
		hkcp=new HikariDataSource();
		//set jdbc properties
		hkcp.setDriverClassName(env.getProperty("jdbc.driver"));
		hkcp.setJdbcUrl(env.getProperty("jdbc.url"));
		hkcp.setUsername(env.getProperty("jdbc.username"));
		hkcp.setPassword(env.getProperty("password"));
		return hkcp;
	}
	@Bean("sji")
	public SimpleJdbcInsert createSJI() {
		SimpleJdbcInsert sji=null; 
		//create simple jdbc  object
		sji=new SimpleJdbcInsert(createDS());
		return sji;
	}
	@Bean("template")
	public JdbcTemplate createTemplate() {
	    JdbcTemplate template=null;
	    //create jdbc template class object
	    template=new JdbcTemplate(createDS());
	    return template;
	}

}
