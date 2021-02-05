package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingreso database table.
 * 
 */
@Entity
@NamedQuery(name="Ingreso.findAll", query="SELECT i FROM Ingreso i")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngresoPK id;

	public Ingreso() {
	}

	public IngresoPK getId() {
		return this.id;
	}

	public void setId(IngresoPK id) {
		this.id = id;
	}

}