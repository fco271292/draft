package com.fco271292.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fco271292.model.Car
import com.fco271292.repository.CarRepository
import com.fco271292.ws.carro.Carro;
import com.fco271292.ws.carro.GetCarRequest;
import com.fco271292.ws.carro.GetCarResponse;


@Endpoint
public class CarEndpoint {
	
	@Autowired
	CarRepository carRepository;
	
	static final String NAMESPACE_URI = "http://fco271292.com/ws/carro"
	
	@PayloadRoot(namespace = "http://fco271292.com/ws/carro", localPart = "getCarRequest")
	@ResponsePayload
	public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
		
		Car car = carRepository.findOne( Long.parseLong(request.getId()) )
		Carro carro = new Carro()
		carro.setMarca(car?.getTradeMark())
		
		GetCarResponse response = new GetCarResponse()
		response.setCarro(carro);
		
		response
	}
	
}
