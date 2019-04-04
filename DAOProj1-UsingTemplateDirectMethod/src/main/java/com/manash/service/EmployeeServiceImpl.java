package com.manash.service;

import java.util.List;
import java.util.Map;

import com.manash.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}
	@Override
	public int getEmpsCount() {
		int count=0;
		//use DAO
		count=dao.fetchEmpsCount();
		return count;
	}
	@Override
	public String getEmpNameById(int id) {
		String name=null;
		//use DAO
		name=dao.fetchEmpNameById(id);
		return name;
	}
	@Override
	public Map<String, Object> getEmpById(int id) {
        Map<String,Object> map=null;
        //use DAO
        map=dao.fetchEmpById(id);
		return map;
	}
	@Override
	public List<Map<String, Object>> getEmpByDesg(String desg) {
		List<Map<String,Object>> list=null;
		//use DAO
		list=dao.fetchEmpByDesg(desg);
		return list;
	}
	@Override
	public int updateSal(int no, int newsal) {
        int count=0;
        //use DAO
        count=dao.updateEmpSal(7369,100);
		return count;
	}
	@Override
	public int registerEmp(int no, String name, String job) {
       int count=0;
       //use DAO
       count=dao.insertEmp(no, name, job);
		return count;
	}
	@Override
	public int deleteEmp(int no) {
        int count=0;
        //use DAO
        count=dao.deleteEmp(no);
		return count;
	}

}
