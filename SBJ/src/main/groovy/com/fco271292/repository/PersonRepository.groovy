package com.fco271292.repository

import com.fco271292.entity.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository extends CrudRepository<Person,Long>{

}
