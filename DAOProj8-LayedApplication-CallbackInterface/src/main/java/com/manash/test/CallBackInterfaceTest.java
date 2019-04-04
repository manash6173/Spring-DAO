package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.dto.CricketPlayerDTO;
import com.manash.service.CricketPlayerService;
import com.manash.service.CricketPlayerServiceImpl;

public class CallBackInterfaceTest {

	public static void main(String[] args) {
        CricketPlayerService service=null;
		ApplicationContext ctx=null;
		CricketPlayerDTO dto=null;
		//create IOC container
        ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
        //get service class Object
        service=ctx.getBean("playerService",CricketPlayerServiceImpl.class);
        //invok service class method
        System.out.println("Main method");
        dto=service.getPlayerByID(1001);
        System.out.println("1001 player Info::"+dto);
        //close container
        ((AbstractApplicationContext) ctx).close();
	}//main
}//class
