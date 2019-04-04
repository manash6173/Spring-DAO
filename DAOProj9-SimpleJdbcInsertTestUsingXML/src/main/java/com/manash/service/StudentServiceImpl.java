package com.manash.service;


import org.springframework.beans.BeanUtils;

import com.manash.bo.StudentBO;
import com.manash.dao.StudentDAO;
import com.manash.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	

	public StudentServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}


	@Override
	public String registerStudent(StudentDTO dto) {
		StudentBO bo=null;
		int count=0;
		//create Student BO object
		bo=new StudentBO();
		//copy properties from DTO to BO
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.insertStudent(bo);
		if(count==0)
			return "Student Registraction Failed";
		else
			return "Student Registraction Successed";
	}

}
