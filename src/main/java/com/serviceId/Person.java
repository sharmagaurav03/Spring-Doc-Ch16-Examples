package com.serviceId;

// Generated 4 Jun, 2014 11:33:29 AM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Person generated by hbm2java
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@Entity
@Table(name = "person")
public class Person implements java.io.Serializable {

	private Long pId;
	private String first_name;
	private String last_name;

	public Person() {
	}

	public Person(String firstname, String lastname) {
		this.first_name = firstname;
		this.last_name = lastname;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getPId() {
		return pId;
	}

	public void setPId(Long pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "Person [id=" + pId + ", firstname=" + first_name + ", lastname="
				+ last_name + "]";
	}

	@Column(name = "firstname")
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	@Column(name = "lastname")
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
