package com.manash.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.manash.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_BY_DEOTNO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE DEPTNO=?";
	private DataSource ds;
	private EmployeeSelector eSelector;
	public EmployeeDAOImpl(DataSource ds) {
		this.ds = ds;
		eSelector=new EmployeeSelector(ds,GET_EMP_BY_DEOTNO);
	}
	@Override
	public List<EmployeeBO> getEmployeeByDept(int dept) {
		List<EmployeeBO> listbo=null;
		//create Object for ListBo
		listbo=eSelector.findEmpByDept(dept);
		return listbo;
	}
	private final class EmployeeSelector extends MappingSqlQuery<EmployeeBO>{
		  public EmployeeSelector(DataSource ds,String query) {
			  super(ds,query);
			  super.declareParameter(new SqlParameter(Types.NUMERIC));
			  super.compile();		  
		}
		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo=null;
			//create EmployeeBO Object
			bo=new EmployeeBO();
			//set values into bo class
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getInt(4));
			return bo;
		}
		public List<EmployeeBO> findEmpByDept(int dept){
			List<EmployeeBO> listbo=null;
			//create List class object
			listbo=super.execute(dept);
			return listbo;
		}
	}//inner class
}
