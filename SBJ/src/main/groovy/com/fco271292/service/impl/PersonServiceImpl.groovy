package com.fco271292.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.fco271292.model.House
import com.fco271292.model.Person
import com.fco271292.repository.CarRepository
import com.fco271292.repository.HouseRepository
import com.fco271292.repository.PersonRepository
import com.fco271292.service.PersonService

@Service("personService")
class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository
	
	@Autowired
	HouseRepository houseRepository
	
	@Autowired
	CarRepository carRepository
	
	@Override
	public Person save(Person person) {
		
		Person persona
		House casa
		
//		if(person?.house) {
//			casa = new House(address: person?.house?.address)
//			houseRepository.save(casa)
//		}
		
		persona = new Person(name: person.name, lastName: person.lastName, house: person.house, cars:person?.cars, cellPhones: person?.cellPhones)
		persona = personRepository.save(persona)
		
//		person.cars.each{car->
//			Car carro = new Car(tradeMark: car?.tradeMark, person: persona )
//			carRepository.save(carro)
//		}
		
		persona = personRepository.findOne(persona.id as Long)
	}
	
	@Override
	public Person update(Person person) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Person> list() {
		List<Person> personas = personRepository.findAll()
	}

	@Override
	public Person get(Long id) {
		Person person = personRepository.findOne(id) ?: new Person()
	}

}
