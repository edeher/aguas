package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.dao.IFisoQuimicoDAO;
import com.unia.model.FisoQuimico;
import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IMuestraFisoQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class FisoQuimicoBean implements Serializable{

	@Inject 
	private FisoQuimico fisoquimico;
	@Inject
	private MuestraFisoQuimico muestrafisoquimico;
	@Inject 
	private IFisoQuimicoDAO servicefisicoquimico;
	@Inject
	private IMuestraFisoQuimicoService servicemuestrafisoquimico;
	
	private List<FisoQuimico> lstFisoQuimico;
	private List<MuestraFisoQuimico> lstMuestraFisoQuimico;
	private String titulo;
	
	
	@PostConstruct
	public void init() {
		this.titulo="Nuevo";
		lstFisoQuimico= new ArrayList<>();
		
		this.listarfisoquimico();
//		this.promedio();
	}
	
	public void listarfisoquimico() {
		
		try {
			lstFisoQuimico=servicefisicoquimico.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	public void Seleccionar(FisoQuimico t) {
		
		try {
			this.fisoquimico=servicefisicoquimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
	}
public void seleccionarba(FisoQuimico fisoquimico1) {
		
		Faces.setFlashAttribute("fisoquimico1", fisoquimico1);
	}
	public void operar() {
		
		try {
			
			if(fisoquimico.getIdFisoQuimico()>0) {
				servicefisicoquimico.modificar(fisoquimico);
				MensajeManager.mostrarMensaje("Aviso", "MOdificación Exitosa", "INFO");
			}else {
				servicefisicoquimico.registrar(fisoquimico);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
//	public void promedio() {
//		try {
//			double promedio=0;
//			for(FisoQuimico fiso2:this.lstFisoQuimico) {
//				
//				this.lstMuestraFisoQuimico=servicemuestrafisoquimico.listarPorFisoQuimico(fiso2);
//				double suma=0;
//				for(MuestraFisoQuimico mufi2:this.lstMuestraFisoQuimico) {
//					
//					suma +=mufi2.getOpsolidostotal();
//					
//				}
//				promedio=suma/12;
//				fiso2.setPromedio(promedio);
//				servicefisicoquimico.modificar(fiso2);				
//				
//			}
//			
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	public FisoQuimico getFisoquimico() {
		return fisoquimico;
	}
	public void setFisoquimico(FisoQuimico fisoquimico) {
		this.fisoquimico = fisoquimico;
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

	public MuestraFisoQuimico getMuestrafisoquimico() {
		return muestrafisoquimico;
	}

	public void setMuestrafisoquimico(MuestraFisoQuimico muestrafisoquimico) {
		this.muestrafisoquimico = muestrafisoquimico;
	}

	public List<MuestraFisoQuimico> getLstMuestraFisoQuimico() {
		return lstMuestraFisoQuimico;
	}

	public void setLstMuestraFisoQuimico(List<MuestraFisoQuimico> lstMuestraFisoQuimico) {
		this.lstMuestraFisoQuimico = lstMuestraFisoQuimico;
	}
	
	
	
	
}
