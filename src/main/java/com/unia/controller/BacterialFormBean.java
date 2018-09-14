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
public class BacterialFormBean implements Serializable{

	
	@Inject
	private Bacterial bacterial;
	@Inject
	private MuestraBacterial muestrabacterial;
	@Inject 
	private IBacterialService servicebacterial;
	@Inject
	private IMuestraBacterialService servicemuestrabacterial;
	
	private List<Bacterial> lstBacterial;
	private List<MuestraBacterial> lstMuestraBacterial;
	private String titulo;
	private int nro1;
	private int nro2;
	@PostConstruct
	public void init() {
		this.titulo="Nuevo";
		lstMuestraBacterial= new ArrayList<>();
		Bacterial bac=Faces.getFlashAttribute("bacterial1");
		
		
		if(bac!=null) {
			
			this.leer(bac);
			this.listarMuestraBacterial(bac);
		}
	}
		public void limpiarControles() {
			this.titulo="Nuevo";
			this.muestrabacterial.setIdMuestraBacterial((short)0);
			this.muestrabacterial.setCanthuehelmintos((short)0);
			this.muestrabacterial.setColiformes((short)0);
			this.muestrabacterial.setFecha(null);
			this.muestrabacterial.setNromuestra((short)0);
		}
	public void leer(Bacterial b) {
		
		try {
			this.bacterial=servicebacterial.listarPorId(b);
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void listarMuestraBacterial(Bacterial b) {
		
		try {
			lstMuestraBacterial=servicemuestrabacterial.listarPorBacterial(b);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void operar() {
		
		try {
				
				Bacterial bac1=this.bacterial;
			if (muestrabacterial.getIdMuestraBacterial() > 0) {
				muestrabacterial.setBacterial(bac1);
				servicemuestrabacterial.modificar(muestrabacterial);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			} else {
				List<MuestraBacterial> mubac1=this.lstMuestraBacterial;
				for(MuestraBacterial muestrita: mubac1) {
					
					nro1=muestrita.getNromuestra();
				}
				
				if(nro1<12) {
					nro2=nro1+1;

				muestrabacterial.setNromuestra(nro2);
				muestrabacterial.setBacterial(bac1);
				servicemuestrabacterial.registrar(muestrabacterial);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
				}
				
			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void seleccionar(MuestraBacterial t) {
		
		try {
			this.muestrabacterial = servicemuestrabacterial.listarPorId(t);
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		} finally {
			this.titulo = "Modificar";
		}
	}


	public Bacterial getBacterial() {
		return bacterial;
	}


	public void setBacterial(Bacterial bacterial) {
		this.bacterial = bacterial;
	}


	public MuestraBacterial getMuestrabacterial() {
		return muestrabacterial;
	}


	public void setMuestrabacterial(MuestraBacterial muestrabacterial) {
		this.muestrabacterial = muestrabacterial;
	}


	public List<Bacterial> getLstBacterial() {
		return lstBacterial;
	}


	public void setLstBacterial(List<Bacterial> lstBacterial) {
		this.lstBacterial = lstBacterial;
	}


	public List<MuestraBacterial> getLstMuestraBacterial() {
		return lstMuestraBacterial;
	}


	public void setLstMuestraBacterial(List<MuestraBacterial> lstMuestraBacterial) {
		this.lstMuestraBacterial = lstMuestraBacterial;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNro1() {
		return nro1;
	}
	public void setNro1(int nro1) {
		this.nro1 = nro1;
	}
	public int getNro2() {
		return nro2;
	}
	public void setNro2(int nro2) {
		this.nro2 = nro2;
	}
	
	
	
}
