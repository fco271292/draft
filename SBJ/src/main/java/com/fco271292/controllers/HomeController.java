package com.fco271292.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("saludo")
	@ResponseBody
    public String saludo() {
		return "Hola!";
    }
}
