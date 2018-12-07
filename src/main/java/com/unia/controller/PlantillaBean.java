package com.unia.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.unia.model.Usuario;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class PlantillaBean implements Serializable {

	public void verificarSesion() {
		try {

			FacesContext context = FacesContext.getCurrentInstance();
			Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

			if (us == null ) {

				context.getExternalContext().redirect("permisos.xhtml");
			}

		} catch (Exception e) {

			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
			System.out.println("el error es :" + e.getMessage());

		}

	}

}
