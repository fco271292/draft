package com.fco271292.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name='persona')
class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id
	
	@Column(name = "nombre", nullable=true)
	String name
	
	@Column(name = "apellidoPaterno", nullable=true)
	String lastName
	
	@OneToOne(optional=true)
	@JoinColumn(name="casa_id")
	House house
	
	@OneToMany(cascade = CascadeType.ALL /*,mappedBy="person"*/)
	@JoinColumn(name="persona_carro_id")
	List<Car> cars
	
}
