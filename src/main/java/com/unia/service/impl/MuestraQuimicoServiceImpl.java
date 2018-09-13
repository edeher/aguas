package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IMuestraQuimicoDAO;
import com.unia.model.MuestraQuimico;
import com.unia.model.Quimico;
import com.unia.service.IMuestraQuimicoService;

@Named
public class MuestraQuimicoServiceImpl implements IMuestraQuimicoService, Serializable{

	@EJB
	private IMuestraQuimicoDAO dao;
	
	@Override
	public void registrar(MuestraQuimico t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(MuestraQuimico t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<MuestraQuimico> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public MuestraQuimico listarPorId(MuestraQuimico t) throws Exception {
		
		return dao.listarPorId(t);
	}

	@Override
	public List<MuestraQuimico> listarPorQuimico(Quimico q) throws Exception {
		
		return dao.listarPorQuimico(q);
	}

}
