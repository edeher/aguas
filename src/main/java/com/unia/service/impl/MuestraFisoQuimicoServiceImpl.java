package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IMuestraFisoQuimicoDAO;
import com.unia.model.FisoQuimico;
import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IMuestraFisoQuimicoService;

@Named
public class MuestraFisoQuimicoServiceImpl implements IMuestraFisoQuimicoService, Serializable{

	@EJB
	private IMuestraFisoQuimicoDAO dao;
	
	@Override
	public void registrar(MuestraFisoQuimico t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(MuestraFisoQuimico t) throws Exception {
	   dao.modificar(t);
		
	}

	@Override
	public List<MuestraFisoQuimico> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public MuestraFisoQuimico listarPorId(MuestraFisoQuimico t) throws Exception {
		
		return dao.listarPorId(t);
	}

	@Override
	public List<MuestraFisoQuimico> listarPorFisoQuimico(FisoQuimico fi) throws Exception {
		
		return dao.listarPorFisoQuimico(fi);
	}
}
