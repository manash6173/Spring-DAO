package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.manash.config.AppConfig;
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
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//create StudentDTO class Object
		dto=new StudentDTO();
		//add values into student class object
		dto.setSno(0);
		dto.setSname("papu");
		dto.setSaddr("delhi");
		dto.setCourse(".net");
		//get service class object
		service=ctx.getBean("studService",StudentServiceImpl.class);
		//invoke service class object
		register=service.registerStudent(dto);
		System.out.println(register);
		//close IOC Container
		((AbstractApplicationContext) ctx).close();
	}

}
