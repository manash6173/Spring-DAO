package com.manash.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.manash.bo.CricketPlayerBO;

public class CricketPlayerDAOImpl implements CricketPlayerDAO {
	private static final String GET_PLAYER_BY_ID="SELECT * FROM CRICKET_PLAYER WHERE PLAYERID=?";
	private JdbcTemplate jt;
	
	public CricketPlayerDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public CricketPlayerBO findPlayerByID(int id) {
		CricketPlayerBO bo=null;
		//use interface method
		System.out.println("DAO Before Method Call");
		bo=jt.queryForObject(GET_PLAYER_BY_ID,new RowMapperImpl(), id);
		System.out.println("After Method CAll");
		return bo;
	}
	private class RowMapperImpl implements RowMapper<CricketPlayerBO>{

		@Override
		public CricketPlayerBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CricketPlayerBO bo1=null;
			//create object for BO class
			bo1=new CricketPlayerBO();
			System.out.println("DAO Inner Class");
			//get values from resultset object and add to bo class
			bo1.setPlayerID(rs.getInt("playerID"));
			bo1.setPname(rs.getString("pname"));
			bo1.setTeam(rs.getString("team"));
			bo1.setJersyNo(rs.getInt("jersyNo"));
			bo1.setRole(rs.getString("role"));
			
			return bo1;
		}//mapRow
	}//inner class
}//outer class
