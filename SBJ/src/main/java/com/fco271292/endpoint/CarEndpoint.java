package com.fco271292.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fco.carro.Carro;
import com.fco.carro.GetCarRequest;
import com.fco.carro.GetCarResponse;
import com.fco271292.model.Car;
import com.fco271292.repository.CarRepository;


@Endpoint
public class CarEndpoint {
	
	@Autowired
	CarRepository carRepository;
	
	private static final String NAMESPACE_URI = "http://fco.com/carro";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
	@ResponsePayload
	public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
		System.out.println("### "+this.getClass().toString()+" ###");
		
		Car car = carRepository.findOne( Long.parseLong(request.getId()) );
		Carro carro = new Carro();
		carro.setMarca(car.getTradeMark());
		
		GetCarResponse response = new GetCarResponse();
		response.setCarro(carro);
		
		return response;
	}
	
}
