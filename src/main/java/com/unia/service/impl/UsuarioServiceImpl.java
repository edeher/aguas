package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IUsuarioDAO;
import com.unia.model.Usuario;
import com.unia.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService,Serializable{
	@EJB
	private IUsuarioDAO dao;
	
	
	
	@Override
	public void registrar(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario iniciarSesion(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.iniciarSesion(usuario);
	}

}
