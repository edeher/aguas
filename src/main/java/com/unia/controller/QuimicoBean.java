package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Quimico;
import com.unia.service.IQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class QuimicoBean implements Serializable {

	@Inject
	private Quimico quimico;
	@Inject
	private IQuimicoService servicequimico;

	private List<Quimico> lstQuimico;
	private String titulo;

	@PostConstruct
	public void init() {
		lstQuimico = new ArrayList<>();
		this.listarquimico();
	}

	public void listarquimico() {

		try {
			lstQuimico = servicequimico.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void seleccionar(Quimico t) {

		try {
			this.quimico = servicequimico.listarPorId(t);

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		} finally {
			this.titulo = "Modificar";
		}
	}

	public void operar() {
		try {
			if(quimico.getIdQuimico()>0) {
				servicequimico.modificar(quimico);
				MensajeManager.mostrarMensaje("Aviso", "MOdificación Exitosa", "INFO");
			
			}else {
				servicequimico.registrar(quimico);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public Quimico getQuimico() {
		return quimico;
	}

	public void setQuimico(Quimico quimico) {
		this.quimico = quimico;
	}

	public List<Quimico> getLstQuimico() {
		return lstQuimico;
	}

	public void setLstQuimico(List<Quimico> lstQuimico) {
		this.lstQuimico = lstQuimico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
