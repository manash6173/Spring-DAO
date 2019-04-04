package com.manash.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.manash.bo.AuthenticateBO;

public class AuthenticateDAOImpl implements AuthenticateDAO {
	private SimpleJdbcCall sjc;

	public AuthenticateDAOImpl(SimpleJdbcCall sjc) {
		this.sjc = sjc;
	}
	@Override
	public Map<String, Object> checkUser(AuthenticateBO bo) {
		Map<String,Object> inParams=null;
		Map<String, Object> outParam=null;
		//create map object for procedure inParams
		inParams=new HashMap<String, Object>();
		inParams.put("user", bo.getUsern());
		inParams.put("pass",bo.getPwd());
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATE");
		//call execute method
		outParam=sjc.execute(inParams);
		return outParam;
	}

}
