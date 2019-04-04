package com.manash.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.manash.bo.AuthenticateBO;
import com.manash.dao.AuthenticateDAO;
import com.manash.dto.AuthenticateDTO;

public class AuthenticateServiceImpl implements AuthenticateService {
	private AuthenticateDAO dao;

	public AuthenticateServiceImpl(AuthenticateDAO dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> authenticateUser(AuthenticateDTO dto) {
		AuthenticateBO bo=null;
		Map<String,Object> result=null;
		//copy properties from DTO class to BO 
		bo=new AuthenticateBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		result=dao.checkUser(bo);
		return result;
	}
}
