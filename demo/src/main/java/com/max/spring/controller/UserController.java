package com.max.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.max.spring.entity.Comuna;
import com.max.spring.entity.Paciente;
import com.max.spring.entity.Region;
import com.max.spring.repository.RegionRepository;
import com.max.spring.service.PacienteService;

@Controller
public class UserController {
	
	@Autowired
	PacienteService pacienteService;
	
	@Autowired
	RegionRepository regionRepository;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/patient-view")
	public String userForm(Model model) {
		model.addAttribute("paciente", new Paciente());
		model.addAttribute("arrayComunas", getArrayComunas((List)regionRepository.findAll()));
		model.addAttribute("regiones", regionRepository.findAll());
		model.addAttribute("pacienteList", pacienteService.getAllPacientes());
		return "patient/patient-view";
	}
	
	private String getArrayComunas(List<Region> regiones) {
		String array = "";
		for(Region region : regiones) {
			array += region.getIdRegion();
			array += " : [";
			for(Comuna comuna : region.getComunas()) {
				array += "\""+comuna.getIdComuna()+"|"+comuna.getComuna()+"\",";
			}
			array = array.substring(0, array.length()-1);
			array += "],";
		}
		array = array.isEmpty() ? "" : array.substring(0, array.length()-1);
		return array;
	}
	
}
