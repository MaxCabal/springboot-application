package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gasto_detalle database table.
 * 
 */
@Embeddable
public class GastoDetallePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	private int valor;

	public GastoDetallePK() {
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
		if (!(other instanceof GastoDetallePK)) {
			return false;
		}
		GastoDetallePK castOther = (GastoDetallePK)other;
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