package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IFisoQuimicoDAO;
import com.unia.model.FisoQuimico;
import com.unia.service.IFisicoQuimicoService;

@Named
public class FisoQuimicoServiceImpl implements IFisicoQuimicoService, Serializable{

	@EJB
	private IFisoQuimicoDAO dao;
	
	@Override
	public void registrar(FisoQuimico t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(FisoQuimico t) throws Exception {
	dao.modificar(t);
		
	}

	@Override
	public List<FisoQuimico> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public FisoQuimico listarPorId(FisoQuimico t) throws Exception {
		
		return dao.listarPorId(t);
	}

}
