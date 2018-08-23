package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IQuimicoDAO;
import com.unia.model.Quimico;
import com.unia.service.IQuimicoService;

@Named
public class QuimicoServiceImpl implements IQuimicoService, Serializable{
	
	@EJB
	private IQuimicoDAO dao;
	
	
	@Override
	public void registrar(Quimico t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Quimico t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Quimico> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public Quimico listarPorId(Quimico t) throws Exception {
		
		return dao.listarPorId(t);
	}

}
