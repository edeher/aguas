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
@Table(name="bacterial")
public class Bacterial implements Serializable{

	
	
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idBacterial;
		
		@Temporal(TemporalType.DATE)
		@Column(name="fecha", nullable=false)
		private Date fecha;
		
		@Column(name="promedio", columnDefinition="Decimal(10,2)", nullable=false)
		private double promedio;
		
		@OneToMany(mappedBy = "bacterial", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
		private List<MuestraBacterial> muestrasbacterial;

		public int getIdBacterial() {
			return idBacterial;
		}

		public void setIdBacterial(int idBacterial) {
			this.idBacterial = idBacterial;
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

		public List<MuestraBacterial> getMuestrasbacterial() {
			return muestrasbacterial;
		}

		public void setMuestrasbacterial(List<MuestraBacterial> muestrasbacterial) {
			this.muestrasbacterial = muestrasbacterial;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idBacterial;
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
			Bacterial other = (Bacterial) obj;
			if (idBacterial != other.idBacterial)
				return false;
			return true;
		}
		
		
		

}
