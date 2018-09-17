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
@Table(name="muestraquimico")
public class MuestraQuimico implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMuestraQuimico;
	
	@Column (name="nromuestra ", nullable=false)
	private int nromuestra;
	
	@ManyToOne
	@JoinColumn(name="idQuimico", nullable=false)
	private Quimico quimico;
		
	@Column(name="nna3", columnDefinition="Decimal(10,2)", nullable=false)
	private double nna3;
	
	@Column(name="norg", columnDefinition="Decimal(10,2)", nullable=false)
	private double norg;
	
	@Column(name="ppmno3", columnDefinition="Decimal(10,2)", nullable=false)
	private double ppmno3;
	
	@Column(name="volumenfinal", columnDefinition="Decimal(10,2)", nullable=false)
	private double volumenfinal;
	
	@Column(name="volumen", columnDefinition="Decimal(10,2)", nullable=false)
	private double volumen;
	
	@Column(name="metales", columnDefinition="Decimal(10,2)", nullable=false)
	private double metales;
	
	@Column(name="fosforos", columnDefinition="Decimal(10,2)", nullable=false)
	private double fosforos;
	
	@Column(name="p1", columnDefinition="Decimal(10,2)", nullable=false)
	private double p1;
	
	@Column(name="p2", columnDefinition="Decimal(10,2)", nullable=false)
	private double p2;
	
	@Column(name="nitrogenoamoniaca", columnDefinition="Decimal(10,2)", nullable=false)
	private double nitrogenoamoniaca;
	
	@Column(name="cromov", columnDefinition="Decimal(10,2)", nullable=false)
	private double cromov;
	
	@Column(name="mercurio", columnDefinition="Decimal(10,2)", nullable=false)
	private double mercurio;
	
	@Column(name="demandabioquimica", columnDefinition="Decimal(10,2)", nullable=false)
	private double demandabioquimica;
	
	@Column(name="datoa", columnDefinition="Decimal(10,2)", nullable=false)
	private double datoa;
	
	@Column(name="datob", columnDefinition="Decimal(10,2)", nullable=false)
	private double datob;
	
	@Column(name="opdemandaoxigeno", columnDefinition="Decimal(10,2)", nullable=false)
	private double opdemandaoxigeno;
	
	@Column(name="opntr", columnDefinition="Decimal(10,2)", nullable=false)
	private double opntr;
	
	@Column(name="opnitratos", columnDefinition="Decimal(10,2)", nullable=false)
	private double opnitratos;
	
	@Column(name="opgrasasaceites", columnDefinition="Decimal(10,2)", nullable=false)
	private double opgrasasaceites;

	

	public int getIdMuestraQuimico() {
		return idMuestraQuimico;
	}

	public void setIdMuestraQuimico(int idMuestraQuimico) {
		this.idMuestraQuimico = idMuestraQuimico;
	}

	public int getNromuestra() {
		return nromuestra;
	}

	public void setNromuestra(int nromuestra) {
		this.nromuestra = nromuestra;
	}

	public double getNna3() {
		return nna3;
	}

	public void setNna3(double nna3) {
		this.nna3 = nna3;
	}

	public double getNorg() {
		return norg;
	}

	public void setNorg(double norg) {
		this.norg = norg;
	}

	public double getPpmno3() {
		return ppmno3;
	}

	public void setPpmno3(double ppmno3) {
		this.ppmno3 = ppmno3;
	}

	public double getVolumenfinal() {
		return volumenfinal;
	}

	public void setVolumenfinal(double volumenfinal) {
		this.volumenfinal = volumenfinal;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public double getMetales() {
		return metales;
	}

	public void setMetales(double metales) {
		this.metales = metales;
	}

	public double getFosforos() {
		return fosforos;
	}

	public void setFosforos(double fosforos) {
		this.fosforos = fosforos;
	}

	
	public double getP1() {
		return p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	public double getP2() {
		return p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	public double getNitrogenoamoniaca() {
		return nitrogenoamoniaca;
	}

	public void setNitrogenoamoniaca(double nitrogenoamoniaca) {
		this.nitrogenoamoniaca = nitrogenoamoniaca;
	}

	public double getCromov() {
		return cromov;
	}

	public void setCromov(double cromov) {
		this.cromov = cromov;
	}

	public double getMercurio() {
		return mercurio;
	}

	public void setMercurio(double mercurio) {
		this.mercurio = mercurio;
	}

	public double getDemandabioquimica() {
		return demandabioquimica;
	}

	public void setDemandabioquimica(double demandabioquimica) {
		this.demandabioquimica = demandabioquimica;
	}

	public double getDatoa() {
		return datoa;
	}

	public void setDatoa(double datoa) {
		this.datoa = datoa;
	}

	public double getDatob() {
		return datob;
	}

	public void setDatob(double datob) {
		this.datob = datob;
	}

	public double getOpdemandaoxigeno() {
		return opdemandaoxigeno;
	}

	public void setOpdemandaoxigeno(double opdemandaoxigeno) {
		this.opdemandaoxigeno = opdemandaoxigeno;
	}

	public double getOpntr() {
		return opntr;
	}

	public void setOpntr(double opntr) {
		this.opntr = opntr;
	}

	public double getOpnitratos() {
		return opnitratos;
	}

	public void setOpnitratos(double opnitratos) {
		this.opnitratos = opnitratos;
	}

	public double getOpgrasasaceites() {
		return opgrasasaceites;
	}

	public void setOpgrasasaceites(double opgrasasaceites) {
		this.opgrasasaceites = opgrasasaceites;
	}
	
	public Quimico getQuimico() {
		return quimico;
	}

	public void setQuimico(Quimico quimico) {
		this.quimico = quimico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMuestraQuimico;
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
		MuestraQuimico other = (MuestraQuimico) obj;
		if (idMuestraQuimico != other.idMuestraQuimico)
			return false;
		return true;
	}

	
	
	
}
