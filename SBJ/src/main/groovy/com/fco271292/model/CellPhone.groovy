package com.fco271292.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@Entity
@Table(name='telefonoCelular')
//Propiedad de JACKSON para evitar problemas de recursion en relaciones bidireccionales
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id")
class CellPhone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id
	
	@Column(name = "empresaTelefonica", nullable=true)
	String company
	
	@ManyToMany(mappedBy="cellPhones")
	List<Person> persons
	
}
