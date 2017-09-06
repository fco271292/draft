package com.fco271292.springanotaciones.controllers;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonaController {
	
	
	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
}
