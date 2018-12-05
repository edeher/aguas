package com.unia.service;

import com.unia.model.Usuario;

public interface IUsuarioService extends IService<Usuario>{

	
	public Usuario iniciarSesion(Usuario usuario);
}
