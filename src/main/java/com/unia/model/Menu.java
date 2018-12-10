package com.unia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMenu;
	
	@Column(name="nombre", length=100,nullable=false)
	private String nombre;
	
	@Column(name="url", length=100 )
	private String url;
	
	@Column(name="tipo", columnDefinition="char(2)", nullable=false)
	private String tipo="in";
	
	@Column(name="tipoUsuario",columnDefinition="char(2)", nullable=false)
	private String tipoUsuario;
	
	@Column(name="estado", columnDefinition="char(2)", nullable=false)
	private String estado="in";
	
	@ManyToOne
	@JoinColumn(name="idSubmenu")
	private Menu submenu;

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Menu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(Menu submenu) {
		this.submenu = submenu;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMenu;
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
		Menu other = (Menu) obj;
		if (idMenu != other.idMenu)
			return false;
		return true;
	}
	
	
}
