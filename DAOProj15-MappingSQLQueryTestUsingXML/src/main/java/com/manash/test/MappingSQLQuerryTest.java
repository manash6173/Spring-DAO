package com.manash.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.dto.EmployeeDTO;
import com.manash.service.EmployeeService;
import com.manash.service.EmployeeServiceImpl;

public class MappingSQLQuerryTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		List<EmployeeDTO> listdto=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Service class object
		service=ctx.getBean("empService",EmployeeServiceImpl.class);
        //invoke service class  method by passing deptno
		listdto=service.fetchEmployeeByDept(10);
		System.out.println(listdto);
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
