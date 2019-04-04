package com.manash.service;

import java.util.List;
import java.util.Map;

import com.manash.dao.EmpDeptDAO;

public class EmpDeptServiceImpl implements EmpDeptService {
	private EmpDeptDAO dao;

	public EmpDeptServiceImpl(EmpDeptDAO dao) {
		this.dao = dao;
	}

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
