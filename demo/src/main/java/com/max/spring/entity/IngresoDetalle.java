package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingreso_detalle database table.
 * 
 */
@Entity
@Table(name="ingreso_detalle")
@NamedQuery(name="IngresoDetalle.findAll", query="SELECT i FROM IngresoDetalle i")
public class IngresoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngresoDetallePK id;

	private String detalle;

	public IngresoDetalle() {
	}

	public IngresoDetallePK getId() {
		return this.id;
	}

	public void setId(IngresoDetallePK id) {
		this.id = id;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}