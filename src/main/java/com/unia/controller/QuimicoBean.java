package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.MuestraQuimico;
import com.unia.model.Quimico;
import com.unia.service.IMuestraQuimicoService;
import com.unia.service.IQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class QuimicoBean implements Serializable {

	@Inject
	private Quimico quimico;
	@Inject
	private MuestraQuimico muestraquimico;
	@Inject
	private IQuimicoService servicequimico;
	@Inject
	private IMuestraQuimicoService servicemuestraquimico;

	private List<Quimico> lstQuimico;
	private List<MuestraQuimico> lstMuestraQuimico;
	private String titulo;

	@PostConstruct
	public void init() {
		this.titulo = "Nuevo";
		lstQuimico = new ArrayList<>();
		this.listarquimico();
		this.promedio();
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

	public void seleccionarba(Quimico quimico1) {

		Faces.setFlashAttribute("quimico1", quimico1);
	}

	public void operar() {
		try {
			if (quimico.getIdQuimico() > 0) {
				servicequimico.modificar(quimico);
				MensajeManager.mostrarMensaje("Aviso", "MOdificación Exitosa", "INFO");

			} else {
				servicequimico.registrar(quimico);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void promedio() {
		
		try {
			double promedio=0;
			for(Quimico qui2:this.lstQuimico) {
				
				this.lstMuestraQuimico=servicemuestraquimico.listarPorQuimico(qui2);
				double suma=0;
				for(MuestraQuimico muqui2:this.lstMuestraQuimico) {
					
					suma += muqui2.getOpdemandaoxigeno();
				}
				promedio=suma/12;
				qui2.setPromedio(promedio);
				servicequimico.modificar(qui2);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
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

	public MuestraQuimico getMuestraquimico() {
		return muestraquimico;
	}

	public void setMuestraquimico(MuestraQuimico muestraquimico) {
		this.muestraquimico = muestraquimico;
	}

	public List<MuestraQuimico> getLstMuestraQuimico() {
		return lstMuestraQuimico;
	}

	public void setLstMuestraQuimico(List<MuestraQuimico> lstMuestraQuimico) {
		this.lstMuestraQuimico = lstMuestraQuimico;
	}

}
