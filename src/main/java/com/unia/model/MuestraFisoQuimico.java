package com.unia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="muestrafisoquimico")
public class MuestraFisoQuimico implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMuestraFisoQuimico;
		
	@Column (name="nromuestra ", nullable=false)
	private int nromuestra;
	
	@ManyToOne
	@JoinColumn(name="idFisoQuimico", nullable=false)
	private FisoQuimico fisoquimico;
	
	
	@Column(name="ph", columnDefinition="Decimal(10,2)", nullable=false)
	private double ph;
	
	@Column(name="muestraa", columnDefinition="Decimal(10,2)", nullable=false)
	private double muestraa;
	
	@Column(name="muestrab", columnDefinition="Decimal(10,2)", nullable=false)
	private double muestrab;
	
	@Column(name="muestrac", columnDefinition="Decimal(10,2)", nullable=false)
	private double muestrac;
	
	@Column(name="muestrad", columnDefinition="Decimal(10,2)", nullable=false)
	private double muestrad;
	
	@Column(name="muestrae", columnDefinition="Decimal(10,2)", nullable=false)
	private double muestrae;
	
	@Column(name="muestraf", columnDefinition="Decimal(10,2)", nullable=false)
	private double muestraf;
	
	@Column(name="volumen", columnDefinition="Decimal(10,2)", nullable=false)
	private double volumen;
	
	@Column(name="temperatura", columnDefinition="Decimal(10,2)", nullable=false)
	private double temperatura;
	
	@Column(name="opsolidostotal", columnDefinition="Decimal(10,2)", nullable=false)
	private double opsolidostotal;
	
	@Column(name="opsolidosfijo", columnDefinition="Decimal(10,2)", nullable=false)
	private double opsolidosfijo;
	
	@Column(name="opsolidosvolatil", columnDefinition="Decimal(10,2)", nullable=false)
	private double opsolidosvolatil;

	

	public int getIdMuestraFisoQuimico() {
		return idMuestraFisoQuimico;
	}

	public void setIdMuestraFisoQuimico(int idMuestraFisoQuimico) {
		this.idMuestraFisoQuimico = idMuestraFisoQuimico;
	}

	public int getNromuestra() {
		return nromuestra;
	}

	public void setNromuestra(int nromuestra) {
		this.nromuestra = nromuestra;
	}

	public double getPh() {
		return ph;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}

	public double getMuestraa() {
		return muestraa;
	}

	public void setMuestraa(double muestraa) {
		this.muestraa = muestraa;
	}

	public double getMuestrab() {
		return muestrab;
	}

	public void setMuestrab(double muestrab) {
		this.muestrab = muestrab;
	}

	public double getMuestrac() {
		return muestrac;
	}

	public void setMuestrac(double muestrac) {
		this.muestrac = muestrac;
	}

	public double getMuestrad() {
		return muestrad;
	}

	public void setMuestrad(double muestrad) {
		this.muestrad = muestrad;
	}

	public double getMuestrae() {
		return muestrae;
	}

	public void setMuestrae(double muestrae) {
		this.muestrae = muestrae;
	}

	public double getMuestraf() {
		return muestraf;
	}

	public void setMuestraf(double muestraf) {
		this.muestraf = muestraf;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getOpsolidostotal() {
		return opsolidostotal;
	}

	public void setOpsolidostotal(double opsolidostotal) {
		this.opsolidostotal = opsolidostotal;
	}

	public double getOpsolidosfijo() {
		return opsolidosfijo;
	}

	public void setOpsolidosfijo(double opsolidosfijo) {
		this.opsolidosfijo = opsolidosfijo;
	}

	public double getOpsolidosvolatil() {
		return opsolidosvolatil;
	}

	public void setOpsolidosvolatil(double opsolidosvolatil) {
		this.opsolidosvolatil = opsolidosvolatil;
	}
	
	

	public FisoQuimico getFisoquimico() {
		return fisoquimico;
	}

	public void setFisoquimico(FisoQuimico fisoquimico) {
		this.fisoquimico = fisoquimico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMuestraFisoQuimico;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MuestraFisoQuimico other = (MuestraFisoQuimico) obj;
		if (idMuestraFisoQuimico != other.idMuestraFisoQuimico)
			return false;
		return true;
	}

	
	

}
