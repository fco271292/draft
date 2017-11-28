package com.fco271292.repository

import org.springframework.data.repository.CrudRepository

import com.fco271292.model.House

interface HouseRepository extends CrudRepository<House,Long> {

}
