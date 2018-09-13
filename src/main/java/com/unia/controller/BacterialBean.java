package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Bacterial;
import com.unia.service.IBacterialService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class BacterialBean implements Serializable {

	@Inject
	private Bacterial bacterial;
	@Inject
	private IBacterialService servicebacterial;

	private List<Bacterial> lstBacterial;
	private String titulo;

	
	@PostConstruct
	public void init() {
		this.titulo="Nuevo";
		lstBacterial= new ArrayList<>();
		this.listarBacterial();
	}
	
	public void seleccionar(Bacterial t) {
		try {
			this.bacterial = servicebacterial.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		} finally {
			this.titulo = "Modificar";

		}
	}
	public void seleccionarba(Bacterial bacterial1) {
		
		Faces.setFlashAttribute("bacterial1", bacterial1);
	}

	public void listarBacterial() {
		try {
			lstBacterial = servicebacterial.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void operar() {
		try {
			if (bacterial.getIdBacterial() > 0) {

				servicebacterial.modificar(bacterial);

				MensajeManager.mostrarMensaje("Aviso", "MOdificaciónn Exitosa", "INFO");
			} else {
				servicebacterial.registrar(bacterial);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public Bacterial getBacterial() {
		return bacterial;
	}

	public void setBacterial(Bacterial bacterial) {
		this.bacterial = bacterial;
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
