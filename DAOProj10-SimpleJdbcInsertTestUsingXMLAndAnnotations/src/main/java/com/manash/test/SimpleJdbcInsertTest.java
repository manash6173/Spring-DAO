package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.dto.StudentDTO;
import com.manash.service.StudentService;
import com.manash.service.StudentServiceImpl;

public class SimpleJdbcInsertTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		StudentDTO dto=null;
		String register=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
		//create StudentDTO class Object
		dto=new StudentDTO();
		//add values into student class object
		dto.setSno(0);
		dto.setSname("piku");
		dto.setSaddr("delhi");
		dto.setCourse("UI");
		//get service class object
		service=ctx.getBean("studService",StudentServiceImpl.class);
		//invoke service class object
		register=service.registerStudent(dto);
		System.out.println(register);
		//close IOC Container
		((AbstractApplicationContext) ctx).close();
	}

}
