package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.manash.dto.AuthenticateDTO;
import com.manash.service.AuthenticateService;
import com.manash.service.AuthenticateServiceImpl;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticateService service =null;
		AuthenticateDTO dto=null;
		//create ApplicationContext Container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
		//get Service class object from container
        service=ctx.getBean("authService",AuthenticateServiceImpl.class);
        //create Object for DAO
        dto=new AuthenticateDTO();
        //set values in DTO object
        dto.setUsern("raja");
        dto.setPwd("rani");
        //invoke service meyhods
        System.out.println(service.authenticateUser(dto).get("RESULT"));
        //close container
        ((AbstractApplicationContext) ctx).close();
	}

}
