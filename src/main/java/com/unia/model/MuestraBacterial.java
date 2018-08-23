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
@Table(name="muestrabacterial")
public class MuestraBacterial implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMuestraBacterial;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column (name="nromuestra ", nullable=false)
	private int nromuestra;
	
	@ManyToOne
	@JoinColumn(name="idBacterial", nullable=false)
	private Bacterial bacterial;
	
	@Column(name="coliformes", columnDefinition="Decimal(10,2)", nullable=false)
	private double coliformes;
	
	@Column(name="canthuehelmintos", nullable=false)
	private int canthuehelmintos;

	public int getIdMuestraBacterial() {
		return idMuestraBacterial;
	}

	public void setIdMuestraBacterial(int idMuestraBacterial) {
		this.idMuestraBacterial = idMuestraBacterial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNromuestra() {
		return nromuestra;
	}

	public void setNromuestra(int nromuestra) {
		this.nromuestra = nromuestra;
	}
	
	public double getColiformes() {
		return coliformes;
	}

	public void setColiformes(double coliformes) {
		this.coliformes = coliformes;
	}

	public int getCanthuehelmintos() {
		return canthuehelmintos;
	}

	public void setCanthuehelmintos(int canthuehelmintos) {
		this.canthuehelmintos = canthuehelmintos;
	}

	
	
	public Bacterial getBacterial() {
		return bacterial;
	}

	public void setBacterial(Bacterial bacterial) {
		this.bacterial = bacterial;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMuestraBacterial;
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
		MuestraBacterial other = (MuestraBacterial) obj;
		if (idMuestraBacterial != other.idMuestraBacterial)
			return false;
		return true;
	}
	
	
	
}
