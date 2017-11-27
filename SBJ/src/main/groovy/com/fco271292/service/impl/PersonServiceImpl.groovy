package com.fco271292.service.impl

import java.util.List

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.fco271292.model.Person
import com.fco271292.repository.PersonRepository
import com.fco271292.service.PersonService

@Service("personService")
class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository
	
	@Override
	public Person save(Person person) {
		Person p = person ? personRepository.save(person) : new Person()
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

}
