package com.manash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.manash.bo.EmployeeBO;
import com.manash.dao.EmployeeDAO;
import com.manash.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<EmployeeDTO> fetchEmployeeByDept(int dept) {
		List<EmployeeBO> listbo=null;
		List<EmployeeDTO> listdto=null;
		EmployeeDTO dto=null;
		
		//create List class object
		listdto=new ArrayList<EmployeeDTO>();
		dto=new EmployeeDTO();
		//invoke dao class object
		listbo=dao.getEmployeeByDept(dept);
		//copy data from bo to dto
		for (EmployeeBO bo : listbo) {
			dto.setEmpno(bo.getEmpno());
			dto.setEname(bo.getEname());
			dto.setJob(bo.getJob());
			dto.setSal(bo.getSal());
			listdto.add(dto);
		}
		
		return listdto;
	}
}
