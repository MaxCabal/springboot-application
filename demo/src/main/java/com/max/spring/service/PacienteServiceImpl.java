package com.max.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.spring.entity.Paciente;
import com.max.spring.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	PacienteRepository repository;

	@Override
	public Iterable<Paciente> getAllPacientes() {
		return repository.findAll();
	}

}
