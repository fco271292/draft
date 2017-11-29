package com.fco271292.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@Entity
@Table(name='carro')
//Propiedad de JACKSON para evitar problemas de recursion en relaciones bidireccionales
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id")
class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id
	
	@Column(name = "marca", nullable=true)
	String tradeMark
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "persona_id")
//	Person person
}
