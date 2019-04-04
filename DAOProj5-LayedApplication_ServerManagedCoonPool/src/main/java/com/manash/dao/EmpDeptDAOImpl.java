package com.manash.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDeptDAOImpl implements EmpDeptDAO {
	private JdbcTemplate jt;

	public EmpDeptDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public List<Map<String, Object>> fetchDeptsByLoc(String cond) {
       List<Map<String,Object>> list=null;
       //call jdbc Direct method
       list=jt.queryForList("SELECT * FROM DEPT WHERE LOC IN"+cond);
		return list;
	}
}
