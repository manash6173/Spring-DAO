package com.manash.service;

import java.util.List;

import com.manash.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> fetchEmployeeByDept(int dept);

}
