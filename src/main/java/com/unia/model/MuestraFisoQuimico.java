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
	
	
	@Column(name="ph", columnDefinition="Decimal(10,4)", nullable=false)
	private double ph;
	
	
	@Column(name="pf1", columnDefinition="Decimal(10,4)", nullable=false)
	private double pf1;
	
	@Column(name="pc1", columnDefinition="Decimal(10,4)", nullable=false)
	private double pc1;
	
	@Column(name="pi1", columnDefinition="Decimal(10,4)", nullable=false)
	private double pi1;
	
	@Column(name="pf2", columnDefinition="Decimal(10,4)", nullable=false)
	private double pf2;
	
	@Column(name="pc2", columnDefinition="Decimal(10,4)", nullable=false)
	private double pc2;
	
	@Column(name="pi2", columnDefinition="Decimal(10,4)", nullable=false)
	private double pi2;
	
	@Column(name="pf3", columnDefinition="Decimal(10,4)", nullable=false)
	private double pf3;
	
	@Column(name="pc3", columnDefinition="Decimal(10,4)", nullable=false)
	private double pc3;
	
	@Column(name="pi3", columnDefinition="Decimal(10,4)", nullable=false)
	private double pi3;
	
	@Column(name="pf4", columnDefinition="Decimal(10,4)", nullable=false)
	private double pf4;
	
	@Column(name="pc4", columnDefinition="Decimal(10,4)", nullable=false)
	private double pc4;
	
	@Column(name="pi4", columnDefinition="Decimal(10,4)", nullable=false)
	private double pi4;
	
	@Column(name="pf5", columnDefinition="Decimal(10,4)", nullable=false)
	private double pf5;
	
	@Column(name="pc5", columnDefinition="Decimal(10,4)", nullable=false)
	private double pc5;
	
	@Column(name="pi5", columnDefinition="Decimal(10,4)", nullable=false)
	private double pi5;
	
	@Column(name="pf6", columnDefinition="Decimal(10,4)", nullable=false)
	private double pf6;
	
	@Column(name="pc6", columnDefinition="Decimal(10,4)", nullable=false)
	private double pc6;
	
	@Column(name="pi6", columnDefinition="Decimal(10,4)", nullable=false)
	private double pi6;
	
	@Column(name="opsolidostotal1", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidostotal1;
	
	@Column(name="opsolidosfijo1", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosfijo1;
	
	@Column(name="opsolidosvolatil1", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosvolatil1;
	
	@Column(name="opsolidostotal2", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidostotal2;
	
	@Column(name="opsolidosfijo2", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosfijo2;
	
	@Column(name="opsolidosvolatil2", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosvolatil2;
	
	@Column(name="opsolidostotal3", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidostotal3;
	
	@Column(name="opsolidosfijo3", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosfijo3;
	
	@Column(name="opsolidosvolatil3", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosvolatil3;
	
	@Column(name="opsolidostotal4", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidostotal4;
	
	@Column(name="opsolidosfijo4", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosfijo4;
	
	@Column(name="opsolidosvolatil4", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosvolatil4;
	
	@Column(name="opsolidostotal5", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidostotal5;
	
	@Column(name="opsolidosfijo5", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosfijo5;
	
	@Column(name="opsolidosvolatil5", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosvolatil5;
	
	@Column(name="opsolidostotal6", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidostotal6;
	
	@Column(name="opsolidosfijo6", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosfijo6;
	
	@Column(name="opsolidosvolatil6", columnDefinition="Decimal(10,4)", nullable=false)
	private double opsolidosvolatil6;
	
	@Column(name="volumen1", columnDefinition="Decimal(10,4)", nullable=false)
	private double volumen1;
	
	@Column(name="volumen2", columnDefinition="Decimal(10,4)", nullable=false)
	private double volumen2;
	
	@Column(name="volumen3", columnDefinition="Decimal(10,4)", nullable=false)
	private double volumen3;
	
	@Column(name="volumen4", columnDefinition="Decimal(10,4)", nullable=false)
	private double volumen4;
	
	@Column(name="volumen5", columnDefinition="Decimal(10,4)", nullable=false)
	private double volumen5;
	
	@Column(name="volumen6", columnDefinition="Decimal(10,4)", nullable=false)
	private double volumen6;
	
	@Column(name="temperatura", columnDefinition="Decimal(10,4)", nullable=false)
	private double temperatura;
	
	
	@Column(name="promedioTo", columnDefinition="Decimal(10,4)", nullable=false)
	private double promedioTo;
	
	@Column(name="dessoltotal", columnDefinition="Decimal(10,4)", nullable=false)
	private double dessoltotal;
	
	@Column(name="promedioFi", columnDefinition="Decimal(10,4)", nullable=false)
	private double promedioFi;
	
	@Column(name="dessolfi", columnDefinition="Decimal(10,4)", nullable=false)
	private double dessolfi;
	
	@Column(name="promedioVo", columnDefinition="Decimal(10,4)", nullable=false)
	private double promedioVo;
	
	@Column(name="dessolvol", columnDefinition="Decimal(10,4)", nullable=false)
	private double dessolvol;

	public double getPf1() {
		return pf1;
	}

	public void setPf1(double pf1) {
		this.pf1 = pf1;
	}

	public double getPc1() {
		return pc1;
	}

	public void setPc1(double pc1) {
		this.pc1 = pc1;
	}

	public double getPi1() {
		return pi1;
	}

	public void setPi1(double pi1) {
		this.pi1 = pi1;
	}

	public double getPf2() {
		return pf2;
	}

	public void setPf2(double pf2) {
		this.pf2 = pf2;
	}

	public double getPc2() {
		return pc2;
	}

	public void setPc2(double pc2) {
		this.pc2 = pc2;
	}

	public double getPi2() {
		return pi2;
	}

	public void setPi2(double pi2) {
		this.pi2 = pi2;
	}

	public double getPf3() {
		return pf3;
	}

	public void setPf3(double pf3) {
		this.pf3 = pf3;
	}

	public double getPc3() {
		return pc3;
	}

	public void setPc3(double pc3) {
		this.pc3 = pc3;
	}

	public double getPi3() {
		return pi3;
	}

	public void setPi3(double pi3) {
		this.pi3 = pi3;
	}

	public double getPf4() {
		return pf4;
	}

	public void setPf4(double pf4) {
		this.pf4 = pf4;
	}

	public double getPc4() {
		return pc4;
	}

	public void setPc4(double pc4) {
		this.pc4 = pc4;
	}

	public double getPi4() {
		return pi4;
	}

	public void setPi4(double pi4) {
		this.pi4 = pi4;
	}

	public double getPf5() {
		return pf5;
	}

	public void setPf5(double pf5) {
		this.pf5 = pf5;
	}

	public double getPc5() {
		return pc5;
	}

	public void setPc5(double pc5) {
		this.pc5 = pc5;
	}

	public double getPi5() {
		return pi5;
	}

	public void setPi5(double pi5) {
		this.pi5 = pi5;
	}

	public double getPf6() {
		return pf6;
	}

	public void setPf6(double pf6) {
		this.pf6 = pf6;
	}

	public double getPc6() {
		return pc6;
	}

	public void setPc6(double pc6) {
		this.pc6 = pc6;
	}

	public double getPi6() {
		return pi6;
	}

	public void setPi6(double pi6) {
		this.pi6 = pi6;
	}

	public double getOpsolidostotal1() {
		return opsolidostotal1;
	}

	public void setOpsolidostotal1(double opsolidostotal1) {
		this.opsolidostotal1 = opsolidostotal1;
	}

	public double getOpsolidosfijo1() {
		return opsolidosfijo1;
	}

	public void setOpsolidosfijo1(double opsolidosfijo1) {
		this.opsolidosfijo1 = opsolidosfijo1;
	}

	public double getOpsolidosvolatil1() {
		return opsolidosvolatil1;
	}

	public void setOpsolidosvolatil1(double opsolidosvolatil1) {
		this.opsolidosvolatil1 = opsolidosvolatil1;
	}

	public double getOpsolidostotal2() {
		return opsolidostotal2;
	}

	public void setOpsolidostotal2(double opsolidostotal2) {
		this.opsolidostotal2 = opsolidostotal2;
	}

	public double getOpsolidosfijo2() {
		return opsolidosfijo2;
	}

	public void setOpsolidosfijo2(double opsolidosfijo2) {
		this.opsolidosfijo2 = opsolidosfijo2;
	}

	public double getOpsolidosvolatil2() {
		return opsolidosvolatil2;
	}

	public void setOpsolidosvolatil2(double opsolidosvolatil2) {
		this.opsolidosvolatil2 = opsolidosvolatil2;
	}

	public double getOpsolidostotal3() {
		return opsolidostotal3;
	}

	public void setOpsolidostotal3(double opsolidostotal3) {
		this.opsolidostotal3 = opsolidostotal3;
	}

	public double getOpsolidosfijo3() {
		return opsolidosfijo3;
	}

	public void setOpsolidosfijo3(double opsolidosfijo3) {
		this.opsolidosfijo3 = opsolidosfijo3;
	}

	public double getOpsolidosvolatil3() {
		return opsolidosvolatil3;
	}

	public void setOpsolidosvolatil3(double opsolidosvolatil3) {
		this.opsolidosvolatil3 = opsolidosvolatil3;
	}

	public double getOpsolidostotal4() {
		return opsolidostotal4;
	}

	public void setOpsolidostotal4(double opsolidostotal4) {
		this.opsolidostotal4 = opsolidostotal4;
	}

	public double getOpsolidosfijo4() {
		return opsolidosfijo4;
	}

	public void setOpsolidosfijo4(double opsolidosfijo4) {
		this.opsolidosfijo4 = opsolidosfijo4;
	}

	public double getOpsolidosvolatil4() {
		return opsolidosvolatil4;
	}

	public void setOpsolidosvolatil4(double opsolidosvolatil4) {
		this.opsolidosvolatil4 = opsolidosvolatil4;
	}

	public double getOpsolidostotal5() {
		return opsolidostotal5;
	}

	public void setOpsolidostotal5(double opsolidostotal5) {
		this.opsolidostotal5 = opsolidostotal5;
	}

	public double getOpsolidosfijo5() {
		return opsolidosfijo5;
	}

	public void setOpsolidosfijo5(double opsolidosfijo5) {
		this.opsolidosfijo5 = opsolidosfijo5;
	}

	public double getOpsolidosvolatil5() {
		return opsolidosvolatil5;
	}

	public void setOpsolidosvolatil5(double opsolidosvolatil5) {
		this.opsolidosvolatil5 = opsolidosvolatil5;
	}

	public double getOpsolidostotal6() {
		return opsolidostotal6;
	}

	public void setOpsolidostotal6(double opsolidostotal6) {
		this.opsolidostotal6 = opsolidostotal6;
	}

	public double getOpsolidosfijo6() {
		return opsolidosfijo6;
	}

	public void setOpsolidosfijo6(double opsolidosfijo6) {
		this.opsolidosfijo6 = opsolidosfijo6;
	}

	public double getOpsolidosvolatil6() {
		return opsolidosvolatil6;
	}

	public void setOpsolidosvolatil6(double opsolidosvolatil6) {
		this.opsolidosvolatil6 = opsolidosvolatil6;
	}

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

	

	public double getVolumen1() {
		return volumen1;
	}

	public void setVolumen1(double volumen1) {
		this.volumen1 = volumen1;
	}

	public double getVolumen2() {
		return volumen2;
	}

	public void setVolumen2(double volumen2) {
		this.volumen2 = volumen2;
	}

	public double getVolumen3() {
		return volumen3;
	}

	public void setVolumen3(double volumen3) {
		this.volumen3 = volumen3;
	}

	public double getVolumen4() {
		return volumen4;
	}

	public void setVolumen4(double volumen4) {
		this.volumen4 = volumen4;
	}

	public double getVolumen5() {
		return volumen5;
	}

	public void setVolumen5(double volumen5) {
		this.volumen5 = volumen5;
	}

	public double getVolumen6() {
		return volumen6;
	}

	public void setVolumen6(double volumen6) {
		this.volumen6 = volumen6;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public FisoQuimico getFisoquimico() {
		return fisoquimico;
	}

	public void setFisoquimico(FisoQuimico fisoquimico) {
		this.fisoquimico = fisoquimico;
	}

	
	
	public double getPromedioTo() {
		return promedioTo;
	}

	public void setPromedioTo(double promedioTo) {
		this.promedioTo = promedioTo;
	}

	public double getPromedioFi() {
		return promedioFi;
	}

	public void setPromedioFi(double promedioFi) {
		this.promedioFi = promedioFi;
	}

	public double getPromedioVo() {
		return promedioVo;
	}

	public void setPromedioVo(double promedioVo) {
		this.promedioVo = promedioVo;
	}
	
	
	public double getDessoltotal() {
		return dessoltotal;
	}

	public void setDessoltotal(double dessoltotal) {
		this.dessoltotal = dessoltotal;
	}

	public double getDessolfi() {
		return dessolfi;
	}

	public void setDessolfi(double dessolfi) {
		this.dessolfi = dessolfi;
	}

	public double getDessolvol() {
		return dessolvol;
	}

	public void setDessolvol(double dessolvol) {
		this.dessolvol = dessolvol;
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
