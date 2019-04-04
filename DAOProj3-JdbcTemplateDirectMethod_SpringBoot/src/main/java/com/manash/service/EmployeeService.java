package com.manash.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	public int getEmpsCount();
	public String getEmpNameById(int id);
	public Map<String,Object> getEmpById(int id);
	public List<Map<String,Object>> getEmpByDesg(String desg);
	
	public int updateSal(int no,int newsal);
	public int registerEmp(int no,String name,String job);
	public int deleteEmp(int no);
}
