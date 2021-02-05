package com.max.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.max.spring.entity.Region;
import com.max.spring.repository.ComunaRepository;
import com.max.spring.repository.RegionRepository;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	ComunaRepository comunaRepository;
	
	@Autowired
	RegionRepository regionRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo() {
//		return (args) -> {
//			List<Region> regiones = (List<Region>) regionRepository.findAll();
//			for (Region region : regiones) {
//				System.out.println(region.getArrayComunas());
//			}
//		};
//	}

}
