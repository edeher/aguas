package com.unia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Usuario;
import com.unia.service.IUsuarioService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	@Inject
	private Usuario usuario;
	@Inject
	private IUsuarioService serviceusuario;

	private List<Usuario> lstUsuario;

	@PostConstruct
	public void init() {
		usuario = new Usuario();

	}

	public String iniciarSesion() {
		Usuario us;
		String redireccion = null;
		try {

			us = serviceusuario.iniciarSesion(usuario);
			System.out.println("usuario:" + us.getUsuario());
			System.out.println("clave :" + us.getClave());
			
			if(us != null) {
				
				redireccion="mantenimiento";
			}else {
					
				
			}

		

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
		System.out.println(redireccion);
		return redireccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLstUsuario() {
		return lstUsuario;
	}

	public void setLstUsuario(List<Usuario> lstUsuario) {
		this.lstUsuario = lstUsuario;
	}

}
