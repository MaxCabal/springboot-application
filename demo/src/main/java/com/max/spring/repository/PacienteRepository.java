package com.max.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.max.spring.entity.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, String>{

}
