package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Bacterial;
import com.unia.model.MuestraBacterial;
import com.unia.service.IBacterialService;
import com.unia.service.IMuestraBacterialService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class MuestraBacterialBean implements Serializable {

	@Inject
	private MuestraBacterial muestrabacterial;

	@Inject
	private Bacterial bacterial;

	@Inject
	private IMuestraBacterialService servicemuestrabacterial;

	@Inject
	private IBacterialService servicebacterial;

	private List<MuestraBacterial> lstMuestraBacterial;
	private List<Bacterial> lstBacterial;

	private String titulo;

	@PostConstruct
	public void init() {

		lstBacterial = new ArrayList<>();
		lstMuestraBacterial = new ArrayList<>();
		this.listarbacterial();
		this.listarmuestrabacterial();

	}

	public void seleccionar(MuestraBacterial t) {
		try {
			this.muestrabacterial = servicemuestrabacterial.listarPorId(t);
			this.bacterial = muestrabacterial.getBacterial();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		} finally {
			this.titulo = "Modificar";
		}
	}

	public void operar() {

		try {

			if (muestrabacterial.getIdMuestraBacterial() > 0) {
				muestrabacterial.setBacterial(bacterial);
				servicemuestrabacterial.modificar(muestrabacterial);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			} else {
				muestrabacterial.setBacterial(bacterial);
				servicemuestrabacterial.registrar(muestrabacterial);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void listarmuestrabacterial() {
		try {
			lstMuestraBacterial = servicemuestrabacterial.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarbacterial() {
		try {
			lstBacterial = servicebacterial.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public MuestraBacterial getMuestrabacterial() {
		return muestrabacterial;
	}

	public void setMuestrabacterial(MuestraBacterial muestrabacterial) {
		this.muestrabacterial = muestrabacterial;
	}

	public Bacterial getBacterial() {
		return bacterial;
	}

	public void setBacterial(Bacterial bacterial) {
		this.bacterial = bacterial;
	}

	public List<MuestraBacterial> getLstMuestraBacterial() {
		return lstMuestraBacterial;
	}

	public void setLstMuestraBacterial(List<MuestraBacterial> lstMuestraBacterial) {
		this.lstMuestraBacterial = lstMuestraBacterial;
	}

	public List<Bacterial> getLstBacterial() {
		return lstBacterial;
	}

	public void setLstBacterial(List<Bacterial> lstBacterial) {
		this.lstBacterial = lstBacterial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
