package com.pbg.SocketsDemo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Peticion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7871126623054357688L;
	
	@Id
	private String idPeticion;
	private String nodoIP;
	private Date fechaCreacion;
	
	public Peticion() {
		super();
	}
	public Peticion(String idPeticion, String nodoIP, Date fechaCreacion) {
		super();
		this.idPeticion = idPeticion;
		this.nodoIP = nodoIP;
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdPeticion() {
		return idPeticion;
	}
	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}
	public String getNodoIP() {
		return nodoIP;
	}
	public void setNodoIP(String nodoIP) {
		this.nodoIP = nodoIP;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPeticion == null) ? 0 : idPeticion.hashCode());
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
		Peticion other = (Peticion) obj;
		if (idPeticion == null) {
			if (other.idPeticion != null)
				return false;
		} else if (!idPeticion.equals(other.idPeticion))
			return false;
		return true;
	}
	
}
