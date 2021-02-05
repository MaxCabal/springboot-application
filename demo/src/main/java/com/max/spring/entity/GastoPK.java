package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gasto database table.
 * 
 */
@Embeddable
public class GastoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	private int valor;

	public GastoPK() {
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public int getValor() {
		return this.valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GastoPK)) {
			return false;
		}
		GastoPK castOther = (GastoPK)other;
		return 
			this.fecha.equals(castOther.fecha)
			&& (this.valor == castOther.valor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fecha.hashCode();
		hash = hash * prime + this.valor;
		
		return hash;
	}
}