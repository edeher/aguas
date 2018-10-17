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
import com.unia.model.FisoQuimico;
import com.unia.model.MuestraBacterial;
import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IFisicoQuimicoService;
import com.unia.service.IMuestraFisoQuimicoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class FisoQuimicoFormBean implements Serializable {

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
		this.titulo = "Nuevo";
		lstMuestraFisoQuimico = new ArrayList<>();
		FisoQuimico fiso = Faces.getFlashAttribute("fisoquimico1");
		if (fiso != null) {
			this.leer(fiso);
			this.listarMuestraFisoquimico(fiso);
			this.calculooperaciones();
		}
	}

	public void limpiarControles() {
		this.titulo = "Nuevo";
		this.muestrafisoquimico.setIdMuestraFisoQuimico((short) 0);

		this.muestrafisoquimico.setPf1((short) 0);
		this.muestrafisoquimico.setPi1((short) 0);
		this.muestrafisoquimico.setPc1((short) 0);

		this.muestrafisoquimico.setPf2((short) 0);
		this.muestrafisoquimico.setPi2((short) 0);
		this.muestrafisoquimico.setPc2((short) 0);

		this.muestrafisoquimico.setPf3((short) 0);
		this.muestrafisoquimico.setPi3((short) 0);
		this.muestrafisoquimico.setPc3((short) 0);

		this.muestrafisoquimico.setPf4((short) 0);
		this.muestrafisoquimico.setPi4((short) 0);
		this.muestrafisoquimico.setPc4((short) 0);

		this.muestrafisoquimico.setPf5((short) 0);
		this.muestrafisoquimico.setPi5((short) 0);
		this.muestrafisoquimico.setPc5((short) 0);

		this.muestrafisoquimico.setPf6((short) 0);
		this.muestrafisoquimico.setPi6((short) 0);
		this.muestrafisoquimico.setPc6((short) 0);

		this.muestrafisoquimico.setNromuestra((short) 0);

		this.muestrafisoquimico.setOpsolidosfijo1((short) 0);
		this.muestrafisoquimico.setOpsolidostotal1((short) 0);
		this.muestrafisoquimico.setOpsolidosvolatil1((short) 0);

		this.muestrafisoquimico.setOpsolidosfijo2((short) 0);
		this.muestrafisoquimico.setOpsolidostotal2((short) 0);
		this.muestrafisoquimico.setOpsolidosvolatil2((short) 0);

		this.muestrafisoquimico.setOpsolidosfijo3((short) 0);
		this.muestrafisoquimico.setOpsolidostotal3((short) 0);
		this.muestrafisoquimico.setOpsolidosvolatil3((short) 0);

		this.muestrafisoquimico.setOpsolidosfijo4((short) 0);
		this.muestrafisoquimico.setOpsolidostotal4((short) 0);
		this.muestrafisoquimico.setOpsolidosvolatil4((short) 0);

		this.muestrafisoquimico.setOpsolidosfijo5((short) 0);
		this.muestrafisoquimico.setOpsolidostotal5((short) 0);
		this.muestrafisoquimico.setOpsolidosvolatil5((short) 0);

		this.muestrafisoquimico.setOpsolidosfijo6((short) 0);
		this.muestrafisoquimico.setOpsolidostotal6((short) 0);
		this.muestrafisoquimico.setOpsolidosvolatil6((short) 0);

		this.muestrafisoquimico.setPh((short) 0);
		this.muestrafisoquimico.setTemperatura((short) 0);
		this.muestrafisoquimico.setVolumen1((short) 0);
		this.muestrafisoquimico.setVolumen2((short) 0);
		this.muestrafisoquimico.setVolumen3((short) 0);
		this.muestrafisoquimico.setVolumen4((short) 0);
		this.muestrafisoquimico.setVolumen5((short) 0);
		this.muestrafisoquimico.setVolumen6((short) 0);
	}

	public void leer(FisoQuimico t) {
		try {
			this.fisoquimico = servicefisoquimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarMuestraFisoquimico(FisoQuimico t) {
		try {
			lstMuestraFisoQuimico = servicemuestrafisoquimico.listarPorFisoQuimico(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void operar() {
		try {

			FisoQuimico fiso1 = this.fisoquimico;
			if (muestrafisoquimico.getIdMuestraFisoQuimico() > 0) {
				muestrafisoquimico.setFisoquimico(fiso1);
				servicemuestrafisoquimico.modificar(muestrafisoquimico);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
				this.calculooperaciones();
				this.listarMuestraFisoquimico(fiso1);
				this.limpiarControles();

			} else {

				List<MuestraFisoQuimico> mufiso1 = this.lstMuestraFisoQuimico;
				for (MuestraFisoQuimico muestrita : mufiso1) {
					nro1 = muestrita.getNromuestra();
				}
				if (nro1 < 12) {
					nro2 = nro1 + 1;
					muestrafisoquimico.setNromuestra(nro2);
					muestrafisoquimico.setFisoquimico(fiso1);
					servicemuestrafisoquimico.registrar(muestrafisoquimico);
					MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
					this.calculooperaciones();
					this.listarMuestraFisoquimico(fiso1);
					this.limpiarControles();

				}

			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void seleccionar(MuestraFisoQuimico t) {
		try {
			this.muestrafisoquimico = servicemuestrafisoquimico.listarPorId(t);
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		} finally {
			this.titulo = "Modificar";
		}

	}

	public void calculooperaciones() {

		try {
			FisoQuimico fiso3 = this.fisoquimico;
			this.lstMuestraFisoQuimico = servicemuestrafisoquimico.listarPorFisoQuimico(fiso3);
			double sototal1 = 0, sofijo1 = 0, sovolatil1 = 0, sototal2 = 0, sofijo2 = 0, sovolatil2 = 0, sototal3 = 0,
					sofijo3 = 0, sovolatil3 = 0, sototal4 = 0, sofijo4 = 0, sovolatil4 = 0, sototal5 = 0, sofijo5 = 0,destotal=0,desfijo=0,desvol=0,
					sovolatil5 = 0, sototal6 = 0, sofijo6 = 0, sovolatil6 = 0, promediototal=0,promediofijo=0, promediovolatil=0;
			for (MuestraFisoQuimico mufiso : this.lstMuestraFisoQuimico) {

				sofijo1 = ((mufiso.getPi1() - mufiso.getPf1()) * 1000) / mufiso.getVolumen1();
				sototal1 = ((mufiso.getPi1() - mufiso.getPc1()) * 1000) / mufiso.getVolumen1();
				sovolatil1 = ((mufiso.getPf1() - mufiso.getPc1()) * 1000) / mufiso.getVolumen1();
				
				sofijo2 = ((mufiso.getPi2() - mufiso.getPf2()) * 1000) / mufiso.getVolumen2();
				sototal2 = ((mufiso.getPi2() - mufiso.getPc2()) * 1000) / mufiso.getVolumen2();
				sovolatil2 = ((mufiso.getPf2() - mufiso.getPc2()) * 1000) / mufiso.getVolumen2();
				
				sofijo3 = ((mufiso.getPi3() - mufiso.getPf3()) * 1000) / mufiso.getVolumen3();
				sototal3 = ((mufiso.getPi3() - mufiso.getPc3()) * 1000) / mufiso.getVolumen3();
				sovolatil3 = ((mufiso.getPf3() - mufiso.getPc3()) * 1000) / mufiso.getVolumen3();
				
				sofijo4 = ((mufiso.getPi4() - mufiso.getPf4()) * 1000) / mufiso.getVolumen4();
				sototal4 = ((mufiso.getPi4() - mufiso.getPc4()) * 1000) / mufiso.getVolumen4();
				sovolatil4 = ((mufiso.getPf4() - mufiso.getPc4()) * 1000) / mufiso.getVolumen4();
				
				sofijo5 = ((mufiso.getPi5() - mufiso.getPf5()) * 1000) / mufiso.getVolumen5();
				sototal5 = ((mufiso.getPi5() - mufiso.getPc5()) * 1000) / mufiso.getVolumen5();
				sovolatil5 = ((mufiso.getPf5() - mufiso.getPc5()) * 1000) / mufiso.getVolumen5();
				
				sofijo6 = ((mufiso.getPi6() - mufiso.getPf6()) * 1000) / mufiso.getVolumen6();
				sototal6 = ((mufiso.getPi6() - mufiso.getPc6()) * 1000) / mufiso.getVolumen6();
				sovolatil6 = ((mufiso.getPf6() - mufiso.getPc6()) * 1000) / mufiso.getVolumen6();
				
				

				mufiso.setOpsolidostotal1(sototal1);
				mufiso.setOpsolidosfijo1(sofijo1);
				mufiso.setOpsolidosvolatil1(sovolatil1);

				mufiso.setOpsolidostotal2(sototal2);
				mufiso.setOpsolidosfijo2(sofijo2);
				mufiso.setOpsolidosvolatil2(sovolatil2);

				mufiso.setOpsolidostotal3(sototal3);
				mufiso.setOpsolidosfijo3(sofijo3);
				mufiso.setOpsolidosvolatil3(sovolatil3);

				mufiso.setOpsolidostotal4(sototal4);
				mufiso.setOpsolidosfijo4(sofijo4);
				mufiso.setOpsolidosvolatil4(sovolatil4);

				mufiso.setOpsolidostotal5(sototal5);
				mufiso.setOpsolidosfijo5(sofijo5);
				mufiso.setOpsolidosvolatil5(sovolatil5);

				mufiso.setOpsolidostotal6(sototal6);
				mufiso.setOpsolidosfijo6(sofijo6);
				mufiso.setOpsolidosvolatil6(sovolatil6);
				
				promediofijo=(mufiso.getOpsolidosfijo1()+mufiso.getOpsolidosfijo2()+mufiso.getOpsolidosfijo3()+mufiso.getOpsolidosfijo4()+mufiso.getOpsolidosfijo5()+mufiso.getOpsolidosfijo6())/6;
				promediototal=(mufiso.getOpsolidostotal1()+mufiso.getOpsolidostotal2()+mufiso.getOpsolidostotal3()+mufiso.getOpsolidostotal4()+mufiso.getOpsolidostotal5()+mufiso.getOpsolidostotal6())/6;
				promediovolatil=(mufiso.getOpsolidosvolatil1()+mufiso.getOpsolidosvolatil2()+mufiso.getOpsolidosvolatil3()+mufiso.getOpsolidosvolatil4()+mufiso.getOpsolidosvolatil5()+mufiso.getOpsolidosvolatil6())/6;
				
				destotal= Math.sqrt((Math.pow((mufiso.getOpsolidostotal1()-promediototal),2)+Math.pow((mufiso.getOpsolidostotal2()-promediototal),2)+Math.pow((mufiso.getOpsolidostotal3()-promediototal),2)+Math.pow((mufiso.getOpsolidostotal4()-promediototal),2)+Math.pow((mufiso.getOpsolidostotal5()-promediototal),2)+Math.pow((mufiso.getOpsolidostotal6()-promediototal),2))/6);
				desfijo= Math.sqrt((Math.pow((mufiso.getOpsolidosfijo1()-promediofijo),2)+Math.pow((mufiso.getOpsolidosfijo2()-promediofijo),2)+Math.pow((mufiso.getOpsolidosfijo3()-promediofijo),2)+Math.pow((mufiso.getOpsolidosfijo4()-promediofijo),2)+Math.pow((mufiso.getOpsolidosfijo5()-promediofijo),2)+Math.pow((mufiso.getOpsolidosfijo6()-promediofijo),2))/6);
				desvol= Math.sqrt((Math.pow((mufiso.getOpsolidosvolatil1()-promediovolatil),2)+Math.pow((mufiso.getOpsolidosvolatil2()-promediovolatil),2)+Math.pow((mufiso.getOpsolidosvolatil3()-promediovolatil),2)+Math.pow((mufiso.getOpsolidosvolatil4()-promediovolatil),2)+Math.pow((mufiso.getOpsolidosvolatil5()-promediovolatil),2)+Math.pow((mufiso.getOpsolidosvolatil6()-promediovolatil),2))/6);
				
				
				
				
				mufiso.setPromedioFi(promediofijo);
				mufiso.setPromedioTo(promediototal);
				mufiso.setPromedioVo(promediovolatil);
				mufiso.setDessoltotal(destotal);
				mufiso.setDessolfi(desfijo);
				mufiso.setDessolvol(desvol);
				
								
				servicemuestrafisoquimico.modificar(mufiso);

			}
			
			

		} catch (Exception e) {
			// TODO: handle exception
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
