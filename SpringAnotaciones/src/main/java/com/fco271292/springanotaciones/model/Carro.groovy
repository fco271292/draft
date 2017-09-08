package com.fco271292.springanotaciones.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
class Carro implements Serializable {
	Integer id
	String descripcion
}
