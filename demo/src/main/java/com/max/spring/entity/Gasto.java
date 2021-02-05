package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gasto database table.
 * 
 */
@Entity
@NamedQuery(name="Gasto.findAll", query="SELECT g FROM Gasto g")
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GastoPK id;

	public Gasto() {
	}

	public GastoPK getId() {
		return this.id;
	}

	public void setId(GastoPK id) {
		this.id = id;
	}

}