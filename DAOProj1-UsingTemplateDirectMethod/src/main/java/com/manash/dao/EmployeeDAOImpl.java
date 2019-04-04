package com.manash.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;

public class EmployeeDAOImpl implements EmployeeDAO {
	@NonNull
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	@NonNull
	private static final String GET_EMP_NAME_BY_ID="SELECT ENAME FROM EMP WHERE EMPNO=?";
	@NonNull
	private static final String GET_EMP_BY_DESG="SELECT * FROM EMP WHERE JOB=?";
	@NonNull
	private static final String GET_EMP_BY_ID="SELECT * FROM EMP WHERE EMPNO=?";
	
	
	
	@NonNull
	private static final String UPDATE_EMP_SAL="UPDATE EMP SET SAL=SAL+? WHERE EMPNO=?";
	@NonNull
	private static final String REGISTRE_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB) VALUES(?,?,?)";
	@NonNull
	private static final String REMOVE_EMP="DELETE FROM EMP WHERE EMPNO=?";
	
	
	private JdbcTemplate jt;
	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
		
	@Override
	public int fetchEmpsCount() {
		int count=0;
		//call query for method
		count=jt.queryForObject(GET_EMPS_COUNT,Integer.class);
		return count;
	}

	@Override
	public String fetchEmpNameById(int id) {
		String name=null;
		name=jt.queryForObject(GET_EMP_BY_ID,String.class,id);
		return name;
	}

	@Override
	public Map<String, Object> fetchEmpById(int id) {
		Map<String,Object> map=null;
		map=jt.queryForMap(GET_EMP_BY_ID, id);
		return map;
	}

	@Override
	public List<Map<String, Object>> fetchEmpByDesg(String desg) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList(GET_EMP_BY_DESG, desg);
		return list;
	}

	@Override
	public int updateEmpSal(int no, int newsal) {
        int count=0;
        count=jt.update(UPDATE_EMP_SAL, Integer.class, no,newsal);
		return count;
	}

	@Override
	public int insertEmp(int no, String name, String job) {
		int count=0;
		count=jt.update(REGISTRE_EMP, Integer.class,no,name,job);
		return count;
	}

	@Override
	public int deleteEmp(int no) {
       int count=0;
       count=jt.update(REMOVE_EMP, Integer.class,no);
		return count;
	}

}
