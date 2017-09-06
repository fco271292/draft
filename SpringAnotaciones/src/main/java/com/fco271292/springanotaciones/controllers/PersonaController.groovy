package com.fco271292.springanotaciones.controllers;


import com.fco271292.springanotaciones.model.Persona
import groovy.json.JsonOutput;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody

@Controller
public class PersonaController {
	
	
	@RequestMapping(value = "/persona", method = RequestMethod.GET,produces="application/json")
	@ResponseBody String index(@RequestParam(value="nombre",required=false) String nombre) {
		String params = nombre?.toUpperCase() ?: new Date().format('dd-MM-YYY HH:mm:ss')
		JsonOutput.toJson(params)
	}
	
	@RequestMapping(value = "/personaObjeto", method = RequestMethod.POST,produces="application/json")
	@ResponseBody String personaObjeto(@RequestBody Persona persona) {
		Persona params = persona.nombre ?: new Date().format('dd-MM-YYY HH:mm:ss')
		JsonOutput.toJson(params)
	}
	
}
