package com.fco271292.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import com.fco271292.client.ClientSOAP
import com.fco271292.model.Car

@Controller
@RequestMapping("/carro")
class CarController {
	
	@Autowired
	ClientSOAP clientSOAP
	
	@RequestMapping(value = "get/{idCar}",  method = RequestMethod.GET, produces = "application/xml")
	@ResponseBody
	String getCar(@PathVariable String idCar) {
		clientSOAP.getCar(idCar)
	}
	
}
