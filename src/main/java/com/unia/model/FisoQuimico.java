package com.unia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fisoquimico")
public class FisoQuimico implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFisoQuimico;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	
	
	@OneToMany(mappedBy = "fisoquimico", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<MuestraFisoQuimico > muestrasfisoquimico;
	

	public int getIdFisoQuimico() {
		return idFisoQuimico;
	}

	public void setIdFisoQuimico(int idFisoQuimico) {
		this.idFisoQuimico = idFisoQuimico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<MuestraFisoQuimico> getMuestrasfisoquimico() {
		return muestrasfisoquimico;
	}

	public void setMuestrasfisoquimico(List<MuestraFisoQuimico> muestrasfisoquimico) {
		this.muestrasfisoquimico = muestrasfisoquimico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFisoQuimico;
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
		FisoQuimico other = (FisoQuimico) obj;
		if (idFisoQuimico != other.idFisoQuimico)
			return false;
		return true;
	}

	
	
	
}
