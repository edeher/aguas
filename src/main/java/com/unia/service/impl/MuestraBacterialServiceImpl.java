package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IMuestraBacterialDAO;
import com.unia.model.MuestraBacterial;
import com.unia.service.IMuestraBacterialService;

@Named
public class MuestraBacterialServiceImpl implements IMuestraBacterialService, Serializable{

	@EJB
	private IMuestraBacterialDAO dao;
	
	@Override
	public void registrar(MuestraBacterial t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(MuestraBacterial t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<MuestraBacterial> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public MuestraBacterial listarPorId(MuestraBacterial t) throws Exception {
		
		return dao.listarPorId(t);
	}

}
