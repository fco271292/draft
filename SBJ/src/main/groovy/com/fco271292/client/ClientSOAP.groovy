package com.fco271292.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

import wslite.soap.SOAPClient

@Service
@PropertySource("classpath:application.properties")
class ClientSOAP {
	
	@Autowired
	Environment env
	
	def getCar(String idCar) {
		
		String puerto = env.getProperty("server.port")
		
		def client = new SOAPClient("http://localhost:${puerto}/ws/carro.wsdl")
		def response = client.send( SOAPAction: "getCar"){
			body {
				getCarRequest('xmlns':'http://fco271292.com/ws/carro'){
					id(idCar as String)
				}
			}
		}
		response.text
	}
	
}
