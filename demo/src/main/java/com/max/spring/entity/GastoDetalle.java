package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gasto_detalle database table.
 * 
 */
@Entity
@Table(name="gasto_detalle")
@NamedQuery(name="GastoDetalle.findAll", query="SELECT g FROM GastoDetalle g")
public class GastoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GastoDetallePK id;

	private String detalle;

	public GastoDetalle() {
	}

	public GastoDetallePK getId() {
		return this.id;
	}

	public void setId(GastoDetallePK id) {
		this.id = id;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}