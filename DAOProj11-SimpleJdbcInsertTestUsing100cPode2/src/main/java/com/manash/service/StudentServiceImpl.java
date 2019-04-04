package com.manash.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.bo.StudentBO;
import com.manash.dao.StudentDAO;
import com.manash.dto.StudentDTO;

@Service("studService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	


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
