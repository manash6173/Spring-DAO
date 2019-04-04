package com.manash.dao;

import java.util.Map;

import com.manash.bo.AuthenticateBO;

public interface AuthenticateDAO {
	public Map<String, Object> checkUser(AuthenticateBO bo);
}
