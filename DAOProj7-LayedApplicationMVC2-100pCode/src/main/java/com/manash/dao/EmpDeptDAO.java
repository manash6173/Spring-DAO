package com.manash.dao;

import java.util.List;
import java.util.Map;

public interface EmpDeptDAO {
	public List<Map<String,Object>> fetchDeptsByLoc(String cond);

}
