package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.FisoQuimico;
import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IFisicoQuimicoService;
import com.unia.service.IMuestraFisoQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class MuestraFisicoQuimicoBean implements Serializable {

	@Inject
	private MuestraFisoQuimico muestrafisoquimico;
	@Inject
	private FisoQuimico fisoquimico;
	@Inject
	private IMuestraFisoQuimicoService servicemuestrafisoquimico;
	@Inject
	private IFisicoQuimicoService servicefisoquimico;

	private List<MuestraFisoQuimico> lstMuestraFisoQuimico;
	private List<FisoQuimico> lstFisoQuimico;

	private String titulo;

	@PostConstruct
	public void init() {
		lstMuestraFisoQuimico = new ArrayList<>();
		lstFisoQuimico = new ArrayList<>();
		this.listarfisoquimico();
		this.listarmuestrafisoquimico();
	}

	public void seleccionar(MuestraFisoQuimico t) {
		
		try {
			this.muestrafisoquimico=servicemuestrafisoquimico.listarPorId(t);
			this.fisoquimico=muestrafisoquimico.getFisoquimico();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}

	}

	public void operar() {
		
		try {
			
			if(muestrafisoquimico.getIdMuestraFisoQuimico()>0) {
				muestrafisoquimico.setFisoquimico(fisoquimico);
				servicemuestrafisoquimico.modificar(muestrafisoquimico);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			}else {
				muestrafisoquimico.setFisoquimico(fisoquimico);
				servicemuestrafisoquimico.registrar(muestrafisoquimico);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
			
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void listarmuestrafisoquimico() {
		try {
			lstMuestraFisoQuimico = servicemuestrafisoquimico.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarfisoquimico() {

		try {
			lstFisoQuimico = servicefisoquimico.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public MuestraFisoQuimico getMuestrafisoquimico() {
		return muestrafisoquimico;
	}

	public void setMuestrafisoquimico(MuestraFisoQuimico muestrafisoquimico) {
		this.muestrafisoquimico = muestrafisoquimico;
	}

	public FisoQuimico getFisoquimico() {
		return fisoquimico;
	}

	public void setFisoquimico(FisoQuimico fisoquimico) {
		this.fisoquimico = fisoquimico;
	}

	public List<MuestraFisoQuimico> getLstMuestraFisoQuimico() {
		return lstMuestraFisoQuimico;
	}

	public void setLstMuestraFisoQuimico(List<MuestraFisoQuimico> lstMuestraFisoQuimico) {
		this.lstMuestraFisoQuimico = lstMuestraFisoQuimico;
	}

	public List<FisoQuimico> getLstFisoQuimico() {
		return lstFisoQuimico;
	}

	public void setLstFisoQuimico(List<FisoQuimico> lstFisoQuimico) {
		this.lstFisoQuimico = lstFisoQuimico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
