package com.max.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atencion database table.
 * 
 */
@Entity
@NamedQuery(name="Atencion.findAll", query="SELECT a FROM Atencion a")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_atencion")
	private int idAtencion;

	private String diagnostico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fec_control")
	private Date fecControl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String tratamiento;

	private int valor;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="rut")
	private Paciente paciente;

	public Atencion() {
	}

	public int getIdAtencion() {
		return this.idAtencion;
	}

	public void setIdAtencion(int idAtencion) {
		this.idAtencion = idAtencion;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Date getFecControl() {
		return this.fecControl;
	}

	public void setFecControl(Date fecControl) {
		this.fecControl = fecControl;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}