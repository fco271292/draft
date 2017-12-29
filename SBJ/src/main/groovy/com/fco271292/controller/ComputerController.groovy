package com.fco271292.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.fco271292.model.Computer
import com.fco271292.repository.ComputerRepository

@RestController
@RequestMapping("/computadora")
class ComputerController {
	
	@Autowired
	ComputerRepository computerRepository
	
	@Autowired
	MongoTemplate mongoTemplate
	
	List<Computer> listaComputadoras = []
	
	@RequestMapping(value = "list",  method = RequestMethod.GET, produces = "application/json")
	List<Computer> list() {
		listaComputadoras = computerRepository.findAll()
	}
	
	@RequestMapping(value = "save",  method = RequestMethod.POST, produces = "application/json")
	Computer save(@RequestBody Computer computer) {
		Computer computadora = computerRepository.save(computer)
	}
	
	@RequestMapping(value = "getByTrademark",  method = RequestMethod.GET, produces = "application/json")
	Computer getByTrademark(@RequestParam tradeMark) {
		Computer computadora = computerRepository.findByTradeMark(tradeMark)
	}
	
	@RequestMapping(value = "update",  method = RequestMethod.PUT, produces = "application/json")
	Computer update(@RequestParam tradeMark,@RequestBody Computer computer) {
		Query query = new Query()
		query.addCriteria(Criteria.where('tradeMark').is(tradeMark))
		Update update = new Update()
		update.set('tradeMark',computer?.tradeMark)
		update.set('person',computer.person)
		Computer computadora = mongoTemplate.findAndModify(query, update, Computer)
	}
	
	@RequestMapping(value = "delete",  method = RequestMethod.DELETE, produces = "application/json")
	def delete (@RequestParam tradeMark) {
		
		Boolean respuesta
		
		Computer computadora = computerRepository.findByTradeMark(tradeMark)
		
		if(computadora) {
			computerRepository.delete(computadora?.id)
		}
		
		respuesta = computerRepository.exists(computadora?.id)
		
	}
	
}
