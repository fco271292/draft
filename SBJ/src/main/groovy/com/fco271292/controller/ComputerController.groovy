package com.fco271292.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.fco271292.model.Computer
import com.fco271292.repository.ComputerRepository

import groovy.json.JsonOutput

@RestController
@RequestMapping("/computadora")
class ComputerController {
	
	@Autowired
	ComputerRepository computerRepository
	
	List<Computer> listaComputadoras = []
	
	@RequestMapping(value = "list",  method = RequestMethod.GET, produces = "application/json")
	String list() {
		listaComputadoras = computerRepository.findAll()
		String listaComputadorasJSON = JsonOutput.toJson(listaComputadoras)
		//listaComputadoras
	}
	
	@RequestMapping(value = "save",  method = RequestMethod.POST, produces = "application/json")
	String save(@RequestBody Computer computer) {
		Computer computadora = computerRepository.save(computer)
		String computadoraJSON = JsonOutput.toJson(computadora)
	}
	
}
