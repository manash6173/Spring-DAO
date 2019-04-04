package com.manash.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.service.EmpDeptService;
import com.manash.service.EmpDeptServiceImpl;

@WebServlet(urlPatterns="/controller")
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext ctx;
	EmpDeptService service;
	
	
	public void init(ServletConfig config) throws ServletException {
		//create IOC Container
	ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
	//get service class object
	service=ctx.getBean("deptService",EmpDeptServiceImpl.class);	
	}	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
	 String[] locations=null;
	 RequestDispatcher rd=null;
	 List<Map<String,Object>> list=null;
		//get printwriter object
		pw=res.getWriter();
		//set browser Content Type
		res.setContentType("text/html");
		//get param values 
		locations=req.getParameterValues("loc");
		//invoke service method
		list=service.findDeptsByLoc(locations);
		//create request dispatcher Object
		rd=req.getRequestDispatcher("/result.jsp");
		//keeps results in request attributes
		req.setAttribute("result",list);
		//forward request to JSP file
		rd.forward(req, res);
		//close stream
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	public void destroy() {
		//close IOC Container
		((AbstractApplicationContext) ctx).close();
	}


}
