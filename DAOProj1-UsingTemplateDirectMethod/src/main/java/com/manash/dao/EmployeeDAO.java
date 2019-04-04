package com.manash.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	public int fetchEmpsCount();
	public String fetchEmpNameById(int id);
	public Map<String,Object> fetchEmpById(int id);
	public List<Map<String,Object>> fetchEmpByDesg(String desg);
	
	public int updateEmpSal(int no,int newsal);
	public int insertEmp(int no,String name,String job);
	public int deleteEmp(int no);

}
