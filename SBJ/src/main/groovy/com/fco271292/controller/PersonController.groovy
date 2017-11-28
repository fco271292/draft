package com.fco271292.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody;

import com.fco271292.model.Person
import com.fco271292.repository.PersonRepository
import com.fco271292.service.PersonService

import groovy.json.*

@Controller
@RequestMapping("/persona")
public class PersonController {
	
	@Autowired
	@Qualifier("personService")
	PersonService personService
	
	@Autowired
	PersonRepository pRepo;
	
	@RequestMapping("index")
	String index() {
		"persona/index"
    }
	
	@RequestMapping(value = "save",  method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	ResponseEntity<Person>save(@RequestBody Person person) {
		Person p = personService.save(person)
		new ResponseEntity(p, HttpStatus.CREATED)
	}
	
	@RequestMapping(value = "get/{idPerson}",  method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Person save(@PathVariable Long idPerson) {
		Person p = personService.get(idPerson)	
	}
	
	
}
