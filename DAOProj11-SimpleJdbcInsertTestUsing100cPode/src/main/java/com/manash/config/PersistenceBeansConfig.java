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
@PropertySource(value="classpath:com/manash/commons/jdbc.properties")
public class PersistenceBeansConfig {
	@Autowired
	Environment env;
	
	@Bean
	public DataSource createDS() {
		HikariDataSource hkcp=null;
		//cretae Datasource object
		hkcp=new HikariDataSource();
		//set jdbc properties 
		hkcp.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkcp.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkcp.setUsername(env.getRequiredProperty("jdbc.username"));
		hkcp.setPassword(env.getRequiredProperty("jdbc.password"));
		
		return hkcp;
	}
	@Bean("sji")
	public SimpleJdbcInsert creatSJI() {
		SimpleJdbcInsert sji=null;
		//create Object for SimpleJdbcInsert
		sji=new SimpleJdbcInsert(createDS());
		return sji;
	}
	@Bean("template")
	public JdbcTemplate createTemplate() {
		JdbcTemplate template=null;
		//create template class object
		template=new JdbcTemplate(createDS());
		return template;
	}
}
