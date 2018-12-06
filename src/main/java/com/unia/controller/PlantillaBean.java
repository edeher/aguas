package com.unia.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.unia.model.Usuario;

@Named
@ViewScoped
public class PlantillaBean implements Serializable{
	
	
	
	
	public void verificarSesion() {
		try {
			
			
			Usuario us=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			System.out.println("usuario en el metodo verificar Sesion : "+us.getUsuario());
			
			if(us.getUsuario()==null) {
				System.out.println("usuario : "+us.getUsuario());
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("permisos.xhtml");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		
		
		
	}

}
