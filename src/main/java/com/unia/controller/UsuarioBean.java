package com.unia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
	

	}

	public String iniciarSesion() {
		Usuario us;
		String redireccion = null;
		try {

			us = serviceusuario.iniciarSesion(usuario);
			
			
			if(us.getUsuario() != null) {
			
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
				
				redireccion="mantenimiento";
				MensajeManager.mostrarMensaje("Aviso", "Ingreso Exitosa", "INFO");
			}else {
				System.out.println("entro al else");
					
				MensajeManager.mostrarMensaje("Aviso", "Credenciales incorrectas", "WARN");
			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	
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
