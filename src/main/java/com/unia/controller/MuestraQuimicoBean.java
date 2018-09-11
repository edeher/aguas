package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.MuestraQuimico;
import com.unia.model.Quimico;
import com.unia.service.IMuestraQuimicoService;
import com.unia.service.IQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class MuestraQuimicoBean implements Serializable{
	
	@Inject
	private MuestraQuimico muestraquimico;
	@Inject
	private Quimico quimico;
	@Inject
	private IMuestraQuimicoService servicemuestraquimico;
	@Inject
	private IQuimicoService servicequimico;
	
	private List<MuestraQuimico> lstMuestraQuimico;
	private List<Quimico> lstQuimico;
	
	private String titulo;
	
	@PostConstruct
	public void init() {
		
		lstMuestraQuimico= new ArrayList<>();
		lstQuimico= new ArrayList<>();
		this.listarmuestraquimico();
		this.listarquimico();
		
	}
	public void listarmuestraquimico() {
		try {
			lstMuestraQuimico= servicemuestraquimico.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void listarquimico() {
		try {
			lstQuimico= servicequimico.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void seleccionar(MuestraQuimico t) {
		try {
			this.muestraquimico=servicemuestraquimico.listarPorId(t);
			this.quimico=muestraquimico.getQuimico();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
	}
	public void operar () {
		try {
			if(muestraquimico.getIdMuestraQuimico()>0) {
				muestraquimico.setQuimico(quimico);
				servicemuestraquimico.modificar(muestraquimico);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			}else {
				muestraquimico.setQuimico(quimico);
				servicemuestraquimico.registrar(muestraquimico);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	public MuestraQuimico getMuestraquimico() {
		return muestraquimico;
	}

	public void setMuestraquimico(MuestraQuimico muestraquimico) {
		this.muestraquimico = muestraquimico;
	}

	public Quimico getQuimico() {
		return quimico;
	}

	public void setQuimico(Quimico quimico) {
		this.quimico = quimico;
	}

	public List<MuestraQuimico> getLstMuestraQuimico() {
		return lstMuestraQuimico;
	}

	public void setLstMuestraQuimico(List<MuestraQuimico> lstMuestraQuimico) {
		this.lstMuestraQuimico = lstMuestraQuimico;
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
