package com.manash.service;

import java.util.List;
import java.util.Map;

public interface EmpDeptService {
	public List<Map<String,Object>> findDeptsByLoc(String[] locations);

}
