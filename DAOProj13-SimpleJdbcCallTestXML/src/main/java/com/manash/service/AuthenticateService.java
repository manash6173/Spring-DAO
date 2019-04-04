package com.manash.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.manash.bo.AuthenticateBO;
import com.manash.dao.AuthenticateDAO;
import com.manash.dto.AuthenticateDTO;

public interface AuthenticateService {
	
	public Map<String,Object> authenticateUser(AuthenticateDTO dto);

}
