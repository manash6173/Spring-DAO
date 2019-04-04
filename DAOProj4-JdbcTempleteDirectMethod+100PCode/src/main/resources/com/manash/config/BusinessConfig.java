package com.manash.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.manash.dao")
public class BusinessConfig {
	
	@Bean("hds")
	public DataSource createDataSource() {
		HikariDataSource hds=null;
		//create data source object
		hds=new HikariDataSource();
		//set properties into DataSource
		hds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hds.setUsername("system");
		hds.setPassword("manash");
		return (DataSource)hds;	
	}
	@Bean("jt")
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jt=null;
		//create jdbc template class object
		jt=new JdbcTemplate(createDataSource());
		return jt;
	}
	

}
