package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.service.EmployeeService;
import com.manash.service.EmployeeServiceImpl;

public class JdbcTemplet_DirectMethodTest {

	public static void main(String[] args) {
		EmployeeService service=null;
		ApplicationContext ctx=null;
		//create IOC Container
		
       ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
       //get service class object
       service=ctx.getBean("empService",EmployeeServiceImpl.class);
       //invoke methods
       System.out.println("Employee Count::"+service.getEmpsCount());
       System.out.println("......................");
       System.out.println(service.getEmpById(7369));
       System.out.println("......................");
       System.out.println(service.getEmpByDesg("CLERK"));
       System.out.println("......................");
      // System.out.println(service.getEmpNameById(7369));
       System.out.println("non-select Operaction");
       //System.out.println(service.registerEmp(1001, "Raja", "Enginer"));
      //System.out.println(service.deleteEmp(106));
       //System.out.println(service.updateSal(7369, 100));
       
       ((AbstractApplicationContext) ctx).close();
	}
}
