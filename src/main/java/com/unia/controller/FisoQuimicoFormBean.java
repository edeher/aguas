package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.FisoQuimico;
import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IFisicoQuimicoService;
import com.unia.service.IMuestraFisoQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class FisoQuimicoFormBean implements Serializable{
	
	@Inject
	private FisoQuimico fisoquimico;
	@Inject
	private IFisicoQuimicoService servicefisoquimico;
	@Inject
	private MuestraFisoQuimico muestrafisoquimico;
	@Inject
	private IMuestraFisoQuimicoService servicemuestrafisoquimico;
	
	private List<FisoQuimico> lstFisoQuimico;
	private List<MuestraFisoQuimico> lstMuestraFisoQuimico;
	private String titulo;
	private int nro1;
	private int nro2;
	@PostConstruct
	public void init() {
		this.titulo="Nuevo";
		lstMuestraFisoQuimico= new ArrayList<>();
		FisoQuimico fiso=Faces.getFlashAttribute("fisoquimico1");
		if(fiso!=null) {
			this.leer(fiso);
			this.listarMuestraFisoquimico(fiso);
		}
	}
	public void limpiarControles() {
		this.titulo="Nuevo";
		this.muestrafisoquimico.setIdMuestraFisoQuimico((short)0);
		this.muestrafisoquimico.setFecha(null);
		this.muestrafisoquimico.setMuestraa((short)0);
		this.muestrafisoquimico.setMuestrab((short)0);
		this.muestrafisoquimico.setNromuestra((short)0);
		this.muestrafisoquimico.setOpsolidosfijo((short)0);
		this.muestrafisoquimico.setOpsolidostotal((short)0);
		this.muestrafisoquimico.setOpsolidosvolatil((short)0);
		this.muestrafisoquimico.setPh((short)0);
		this.muestrafisoquimico.setTemperatura((short)0);
		this.muestrafisoquimico.setVolumen((short)0);
	}
	public void leer(FisoQuimico t) {
		try {
			this.fisoquimico=servicefisoquimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void listarMuestraFisoquimico(FisoQuimico t) {
		try {
			lstMuestraFisoQuimico=servicemuestrafisoquimico.listarPorFisoQuimico(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void operar() {
		try {
				FisoQuimico fiso1=this.fisoquimico;
			if(muestrafisoquimico.getIdMuestraFisoQuimico()>0) {
				muestrafisoquimico.setFisoquimico(fiso1);
				servicemuestrafisoquimico.modificar(muestrafisoquimico);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			}else {
				
				List<MuestraFisoQuimico> mufiso1=this.lstMuestraFisoQuimico;
				for(MuestraFisoQuimico muestrita:mufiso1) {
					nro1=muestrita.getNromuestra();
				}
				if(nro1<12) {
					nro2=nro1+1;
					muestrafisoquimico.setNromuestra(nro2);
					muestrafisoquimico.setFisoquimico(fiso1);
					servicemuestrafisoquimico.registrar(muestrafisoquimico);
					MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
				}
				
			}
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	public void seleccionar(MuestraFisoQuimico t) {
		try {
			this.muestrafisoquimico=servicemuestrafisoquimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
				this.titulo = "Modificar";
			}
		
	}
	
	
	
	
	
	public FisoQuimico getFisoquimico() {
		return fisoquimico;
	}
	public void setFisoquimico(FisoQuimico fisoquimico) {
		this.fisoquimico = fisoquimico;
	}
	public MuestraFisoQuimico getMuestrafisoquimico() {
		return muestrafisoquimico;
	}
	public void setMuestrafisoquimico(MuestraFisoQuimico muestrafisoquimico) {
		this.muestrafisoquimico = muestrafisoquimico;
	}
	public List<FisoQuimico> getLstFisoQuimico() {
		return lstFisoQuimico;
	}
	public void setLstFisoQuimico(List<FisoQuimico> lstFisoQuimico) {
		this.lstFisoQuimico = lstFisoQuimico;
	}
	public List<MuestraFisoQuimico> getLstMuestraFisoQuimico() {
		return lstMuestraFisoQuimico;
	}
	public void setLstMuestraFisoQuimico(List<MuestraFisoQuimico> lstMuestraFisoQuimico) {
		this.lstMuestraFisoQuimico = lstMuestraFisoQuimico;
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
