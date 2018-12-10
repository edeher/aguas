package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IMenuDAO;
import com.unia.model.Menu;
import com.unia.service.IMenuService;

@Named
public class MenuServiceImpl implements IMenuService, Serializable{
	
	@EJB
	private IMenuDAO dao;

	@Override
	public void registrar(Menu t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Menu t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Menu> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Menu listarPorId(Menu t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
