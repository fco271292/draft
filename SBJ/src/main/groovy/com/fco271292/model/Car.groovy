package com.fco271292.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.fasterxml.jackson.annotation.JsonInclude.Include

@Entity
@Table(name='carro')
@JsonInclude(Include.NON_NULL)
//Propiedad de JACKSON para evitar problemas de recursion en relaciones bidireccionales
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id")
//Permite usar las anotaciones dateCreated, lastUpdated de forma automatica en base de datos
@EntityListeners(AuditingEntityListener)
class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id
	
	@Column(name = "marca", nullable=true)
	String tradeMark
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "persona_id")
//	Person person
	
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "yyyy-MM-dd HH:mm:ss z")
	@CreationTimestamp
	Date dateCreated
	
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "yyyy-MM-dd HH:mm:ss z")
	@LastModifiedDate
	Date lastUpdated
	
	@Version
	Long version = 0
	
}
