package com.manash.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages= "com.manash.dao")
public class PersistenceConfig {
	
	@Bean
	public JndiObjectFactoryBean createDS() {
		JndiObjectFactoryBean jobf=null;
		jobf=new JndiObjectFactoryBean();
		jobf.setJndiName("DsJndi");
		return jobf;
	}
	@Bean(name="jt")
	public JdbcTemplate createJT() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate();
		jt.setDataSource((DataSource) createDS());
		return jt;
	}
}
