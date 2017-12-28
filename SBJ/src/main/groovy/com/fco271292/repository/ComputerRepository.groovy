package com.fco271292.repository

import org.springframework.data.mongodb.repository.MongoRepository

import com.fco271292.model.Computer

interface ComputerRepository extends MongoRepository<Computer,Long>{

}
