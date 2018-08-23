package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IBacterialDAO;
import com.unia.model.Bacterial;
import com.unia.service.IBacterialService;

@Named
public class BacterialServiceImpl implements IBacterialService, Serializable {

	@EJB
	private IBacterialDAO dao;
	
	@Override
	public void registrar(Bacterial t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Bacterial t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Bacterial> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public Bacterial listarPorId(Bacterial t) throws Exception {
		
		return dao.listarPorId(t);
	}

}
