package com.fco271292.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonInclude.Include

@Document(collection='computadora')
class Computer implements Serializable{

	@Id
	String id
	
	String tradeMark
	
	Person person
	
}
