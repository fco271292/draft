package com.fco271292.service

import org.springframework.web.bind.annotation.RequestBody

import com.fco271292.model.Person

interface PersonService {
	Person save(@RequestBody Person person)
	Person update (@RequestBody Person person)
	void delete (Long id)
	List<Person> list ()
}
