package com.fco271292.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import com.fco271292.client.ClientSOAP
import com.fco271292.model.Car
import com.fco271292.repository.CarRepository

@Controller
@RequestMapping("/carro")
class CarController {
	
	@Autowired
	ClientSOAP clientSOAP
	
	@Autowired
	CarRepository carRepository
	
	@RequestMapping(value = "get/{idCar}",  method = RequestMethod.GET, produces = "application/xml")
	@ResponseBody
	String getCar(@PathVariable String idCar) {
		clientSOAP.getCar(idCar)
	}
	
	@RequestMapping(value = "save",  method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	Car save (@RequestBody Car car) {
		Car carro = carRepository.save(car) ?: new Car()
	}
	
	@RequestMapping(value = "list",  method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	List<Car> list () {
		List<Car> listaCarros = carRepository.findAll()
	}
	
	@RequestMapping(value = "update",  method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	Car update (@RequestParam id, @RequestBody Car car) {
		Car carro = carRepository.findOne(id as Long)
		carro.tradeMark = car?.tradeMark ?: carro?.tradeMark
		carro = carRepository.save(carro)
	}
	
}
