package com.fco271292.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@Entity
@Table(name='persona')
//Propiedad de JACKSON para evitar problemas de recursion en relaciones bidireccionales
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id")
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="persona_carro_id")
	List<Car> cars
	
	//@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="persona_telefonoCelular", 
		joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "telefonoCelularId", referencedColumnName = "id"))
	List<CellPhone> cellPhones
	
}
