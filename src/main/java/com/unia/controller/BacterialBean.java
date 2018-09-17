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
import com.unia.model.MuestraBacterial;
import com.unia.service.IBacterialService;
import com.unia.service.IMuestraBacterialService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class BacterialBean implements Serializable {

	@Inject
	private Bacterial bacterial;
	@Inject
	private MuestraBacterial muestrabacteral;
	@Inject
	private IBacterialService servicebacterial;
	@Inject
	private IMuestraBacterialService servicemuestrabacterial;

	private List<Bacterial> lstBacterial;
	private List<MuestraBacterial> lstMuestraBacterial;
	private String titulo;

	@PostConstruct
	public void init() {
		this.titulo = "Nuevo";
		lstBacterial = new ArrayList<>();
		this.listarBacterial();
		this.promedio();
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

	public void promedio() {

		try {
			double promedio=0;
			for (Bacterial bac2 : this.lstBacterial) {

				this.lstMuestraBacterial = servicemuestrabacterial.listarPorBacterial(bac2);
				double suma=0;
				for(MuestraBacterial mubac2:this.lstMuestraBacterial) {
					
					suma +=mubac2.getColiformes();
				}
				promedio=suma/12;
				bac2.setPromedio(promedio);
				servicebacterial.modificar(bac2);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
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

	public MuestraBacterial getMuestrabacteral() {
		return muestrabacteral;
	}

	public void setMuestrabacteral(MuestraBacterial muestrabacteral) {
		this.muestrabacteral = muestrabacteral;
	}

	public List<MuestraBacterial> getLstMuestraBacterial() {
		return lstMuestraBacterial;
	}

	public void setLstMuestraBacterial(List<MuestraBacterial> lstMuestraBacterial) {
		this.lstMuestraBacterial = lstMuestraBacterial;
	}

}
