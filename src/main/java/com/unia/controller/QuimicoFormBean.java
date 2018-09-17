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
public class QuimicoFormBean implements Serializable{
	
	@Inject
	private Quimico quimico;
	@Inject
	private IQuimicoService servicequimico;
	@Inject
	private MuestraQuimico muestraquimico;
	@Inject
	private IMuestraQuimicoService servicemuestraquimico;
	
	
	private List<Quimico> lstQuimico;
	private List<MuestraQuimico> lstMuestraQuimico;
	private String titulo;
	private int nro1;
	private int nro2;
	@PostConstruct
	public void inti() {
		this.titulo="Nuevo";
		lstMuestraQuimico= new ArrayList<>();
		Quimico qui=Faces.getFlashAttribute("quimico1");
		if(qui!=null) {
			this.leer(qui);
			this.listarMuestraQuimico(qui);
		}
	}
	
	public void limpiarControles() {
		
		this.titulo="Nuevo";
		this.muestraquimico.setIdMuestraQuimico((short)0);
		this.muestraquimico.setCromov((short)0);
		this.muestraquimico.setDatoa((short)0);
		this.muestraquimico.setDatob((short)0);
		this.muestraquimico.setDemandabioquimica((short)0);
		this.muestraquimico.setFosforos((short)0);
		this.muestraquimico.setMercurio((short)0);
		this.muestraquimico.setMetales((short)0);
		this.muestraquimico.setNitrogenoamoniaca((short)0);
		this.muestraquimico.setNna3((short)0);
		this.muestraquimico.setNorg((short)0);
		this.muestraquimico.setNromuestra((short)0);
		this.muestraquimico.setOpdemandaoxigeno((short)0);
		this.muestraquimico.setOpgrasasaceites((short)0);
		this.muestraquimico.setOpnitratos((short)0);
		this.muestraquimico.setOpntr((short)0);
		this.muestraquimico.setP1((short)0);
		this.muestraquimico.setP2((short)0);
		this.muestraquimico.setPpmno3((short)0);
		this.muestraquimico.setVolumen((short)0);
		this.muestraquimico.setVolumenfinal((short)0);
		
		
	}
	public void leer(Quimico t) {
		
		try {
			this.quimico=servicequimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	public void listarMuestraQuimico(Quimico q) {
		try {
			lstMuestraQuimico=servicemuestraquimico.listarPorQuimico(q);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void operar() {
		
		try {
			Quimico qui1=this.quimico;
			if(muestraquimico.getIdMuestraQuimico()>0) {
				muestraquimico.setQuimico(qui1);
				servicemuestraquimico.modificar(muestraquimico);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
				this.listarMuestraQuimico(qui1);
			}else {
				
				
				
				List<MuestraQuimico> muqui1=this.lstMuestraQuimico;
				for(MuestraQuimico muestrita: muqui1) {
					nro1=muestrita.getNromuestra();
				}
				if(nro1<12) {
					nro2=nro1+1;
					muestraquimico.setQuimico(qui1);
					servicemuestraquimico.registrar(muestraquimico);
					MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
					this.listarMuestraQuimico(qui1);
				}
				
				
				
			}
			
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
		
		
		
	}
	public void seleccionar(MuestraQuimico t) {
		try {
			this.muestraquimico=servicemuestraquimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		} finally {
			this.titulo = "Modificar";
		}
	}
	
	
	public Quimico getQuimico() {
		return quimico;
	}
	public void setQuimico(Quimico quimico) {
		this.quimico = quimico;
	}
	public MuestraQuimico getMuestraquimico() {
		return muestraquimico;
	}
	public void setMuestraquimico(MuestraQuimico muestraquimico) {
		this.muestraquimico = muestraquimico;
	}
	public List<Quimico> getLstQuimico() {
		return lstQuimico;
	}
	public void setLstQuimico(List<Quimico> lstQuimico) {
		this.lstQuimico = lstQuimico;
	}
	public List<MuestraQuimico> getLstMuestraQuimico() {
		return lstMuestraQuimico;
	}
	public void setLstMuestraQuimico(List<MuestraQuimico> lstMuestraQuimico) {
		this.lstMuestraQuimico = lstMuestraQuimico;
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
