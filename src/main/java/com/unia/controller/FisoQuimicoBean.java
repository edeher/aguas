package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.dao.IFisoQuimicoDAO;
import com.unia.model.FisoQuimico;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class FisoQuimicoBean implements Serializable{

	@Inject 
	private FisoQuimico fisoquimico;
	@Inject 
	private IFisoQuimicoDAO servicefisicoquimico;
	
	private List<FisoQuimico> lstFisoQuimico;
	private String titulo;
	
	
	@PostConstruct
	public void init() {
		this.titulo="Nuevo";
		lstFisoQuimico= new ArrayList<>();
		this.listarfisoquimico();
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
	
	
	
	
}
