package com.fco271292.client

import org.springframework.stereotype.Service

import wslite.soap.SOAPClient

@Service
class ClientSOAP {
	
	def getCar(String idCar) {
		
		def client = new SOAPClient('http://localhost:1234/ws/carro.wsdl')
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
