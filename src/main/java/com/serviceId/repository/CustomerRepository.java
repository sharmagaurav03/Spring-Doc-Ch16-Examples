package com.serviceId.repository;

// Generated 4 Jun, 2014 11:33:30 AM 

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceId.Customer;
import com.serviceId.Person;
import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

/**
 * Specifies methods used to obtain and modify Customer related information
 * which is stored in the database.
 */
public class CustomerRepository extends WMGenericDaoImpl<Customer, Long> {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
