package com.unia.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensajeManager {

	public synchronized static void mostrarMensaje(String titulo, String cuerpo, String severidad) {
		
		FacesContext context= FacesContext.getCurrentInstance();
		switch (severidad) {
		case "INFO":
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,titulo,cuerpo) );
				
			break;
		case "WARN":
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,titulo,cuerpo) );
			
			break;
		case "ERROR":
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,titulo,cuerpo) );
			
			break;
		case "FATAL":
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,titulo,cuerpo) );
			
			break;

		default:
			break;
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		
	}
}
