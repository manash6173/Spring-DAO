package com.manash.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("deptDAO")
public class EmpDeptDAOImpl implements EmpDeptDAO {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Map<String, Object>> fetchDeptsByLoc(String cond) {
       List<Map<String,Object>> list=null;
       //call jdbc Direct method
       list=jt.queryForList("SELECT * FROM DEPT WHERE LOC IN"+cond);
		return list;
	}
}
