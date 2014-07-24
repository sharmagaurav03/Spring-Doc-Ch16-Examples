package com.serviceId.controller; 

// Generated 4 Jun, 2014 11:33:30 AM


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceId.Person;
import com.serviceId.service.PersonService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;

/**
 * Controller object for domain model class Person.
 * @see com.serviceId.Person
 */

@RestController
@RequestMapping("/serviceId/person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService service;
	
	private final ObjectMapper objectMapper=new ObjectMapper();

	/**
	 * Processes requests to return lists all available Persons.
	 * 
	 * @param model
	 * @return The name of the  Person list view.
	 */
	 
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Object list(
			@RequestBody QueryFilter[] queryFilters,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Persons list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(queryFilters, pageable);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Object getPersons(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Persons list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(pageable);
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Long countAll() {
		LOGGER.debug("counting Persons");
		Long count = service.countAll();
		return count;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") String id) throws EntityNotFoundException, JsonParseException, JsonMappingException, IOException {
		System.out.println("Getting person with id: " + id);
		Long longId=objectMapper.readValue(id,Long.class );
		Person instance = service.findById(longId);
		System.out.println("Getting person with id: " + instance);
		return instance;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Deleting Person with id: {}" , id);
		Person deleted = service.delete(id);
		return deleted != null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Person editPerson(@PathVariable("id") Long id, @RequestBody Person instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Person with id: {}" , instance.getPId());
        instance.setPId(id);
		instance = service.update(instance);
		LOGGER.debug("Person details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createPerson(@RequestBody Person instance) {
		LOGGER.debug("Create Person with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Person with information: {}" , instance);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
	ResponseEntity<String> handleEntityNotFoundException(Exception e) {
		return new ResponseEntity<String>(String.format("{\"Error\":\"%s\"}",
				e.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setPersonService(PersonService service) {
		this.service = service;
	}
}

