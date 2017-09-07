package com.fco271292.springanotaciones.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
class Persona implements Serializable {
	Integer id
	String nombre
}
