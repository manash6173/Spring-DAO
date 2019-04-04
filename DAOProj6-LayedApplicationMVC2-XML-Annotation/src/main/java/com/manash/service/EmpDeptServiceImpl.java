package com.manash.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.dao.EmpDeptDAO;

@Service("deptService")
public class EmpDeptServiceImpl implements EmpDeptService {
    @Autowired
	private EmpDeptDAO dao;


	@Override
	public List<Map<String, Object>> findDeptsByLoc(String[] locations) {
      List<Map<String,Object>> list=null;
      StringBuffer sb=null;
      //convert values into String as required format ('NEW YORK','CHICAGO','DALLAS','BOSTON')
      sb=new StringBuffer();
      sb.append("(");
      for(int i=0;i<locations.length;i++) {
    	  if(i==locations.length-1) {
    		  sb.append("'"+locations[i]+"'");
    	  }
    	  else {
    		  sb.append("'"+locations[i]+"',");
    	  }
      }
      sb.append(")");
      //use DAO
      list=dao.fetchDeptsByLoc(sb.toString());
		return list;
	}
}
