package com.fco271292.service

import java.util.List

import com.fco271292.model.Person

interface PersonService {
	
	Person save(Person person)
	Person update (Person person)
	void delete (Long id)
	List<Person> list ()
	Person get (Long id)
	
}
