package com.unia.dao;

import javax.ejb.Local;

import com.unia.model.Usuario;

@Local
public interface IUsuarioDAO extends IDAO<Usuario> {
	
	
	public Usuario iniciarSesion(Usuario usuario);

}
