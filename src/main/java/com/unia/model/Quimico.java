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
@Table(name="quimico")
public class Quimico implements Serializable{

	
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idQuimico;
		
		@Temporal(TemporalType.DATE)
		@Column(name="fecha", nullable=false)
		private Date fecha;
		
		@Column(name="promedio", columnDefinition="Decimal(10,2)", nullable=false)
		private double promedio;
		
		@OneToMany(mappedBy = "quimico", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
		private List<MuestraQuimico> muestrasquimico;

		public int getIdQuimico() {
			return idQuimico;
		}

		public void setIdQuimico(int idQuimico) {
			this.idQuimico = idQuimico;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public double getPromedio() {
			return promedio;
		}

		public void setPromedio(double promedio) {
			this.promedio = promedio;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idQuimico;
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
			Quimico other = (Quimico) obj;
			if (idQuimico != other.idQuimico)
				return false;
			return true;
		}
		
		

}
