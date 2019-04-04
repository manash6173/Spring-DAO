package com.manash.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.manash.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String GET_SNO_SEQ="SELECT SEQ_SNO.NEXTVAL FROM DUAL";
	
	@Autowired
	private SimpleJdbcInsert sji;
	@Autowired
	private JdbcTemplate template;

	private int sequenseSno() {
		int seq=0;
		//invoke methods
		seq=template.queryForObject(GET_SNO_SEQ,Integer.class);
		return seq;
	}
	@Override
	public int insertStudent(StudentBO bo) {
		int count=0;
		Map<String,Object> map=null;
		//prepare param for execute method
		map=new HashMap<String,Object>();
		//map.put("sno",bo.getSno());
	   bo.setSno(sequenseSno());
	   map.put("sno", bo.getSno());
		map.put("sname", bo.getSname());
		map.put("saddr",bo.getSaddr());
		map.put("course", bo.getCourse());
		//set table name to sji
		sji.setTableName("STUDENT");
		//invoke execute method 
		count=sji.execute(map);
		return count;
	}
}
