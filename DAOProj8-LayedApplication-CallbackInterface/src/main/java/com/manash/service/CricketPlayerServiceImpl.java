package com.manash.service;

import com.manash.bo.CricketPlayerBO;
import com.manash.dao.CricketPlayerDAO;
import com.manash.dto.CricketPlayerDTO;

public class CricketPlayerServiceImpl implements CricketPlayerService {
	private CricketPlayerDAO dao;
	public CricketPlayerServiceImpl(CricketPlayerDAO dao) {
		this.dao = dao;
	}
	@Override
	public CricketPlayerDTO getPlayerByID(int id) {
        CricketPlayerBO bo=null;
        CricketPlayerDTO dto=null;
		//use DAO
        System.out.println("Service before Method Call");
        bo=dao.findPlayerByID(id);
        System.out.println("Service After Method Call");
        //convert bo to dto
        dto=new CricketPlayerDTO();
        dto.setPlayerID(bo.getPlayerID());
        dto.setPname(bo.getPname());
        dto.setTeam(bo.getTeam());
        dto.setJersyNo(bo.getJersyNo());
		return dto;
	}
}