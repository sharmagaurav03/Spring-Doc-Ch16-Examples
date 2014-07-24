package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serviceId.Person;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * Service object for domain model class Person.
 * @see com.serviceId.Person
 */

public interface PersonService {

   /**
	 * Creates a new person.
	 * 
	 * @param created
	 *            The information of the created person.
	 * @return The created person.
	 */
	public Person create(Person created);

	/**
	 * Deletes a person.
	 * 
	 * @param personId
	 *            The id of the deleted person.
	 * @return The deleted person.
	 * @throws EntityNotFoundException
	 *             if no person is found with the given id.
	 */
	public Person delete(Long personId) throws EntityNotFoundException;

	/**
	 * Finds all persons.
	 * 
	 * @return A list of persons.
	 */
	public Page<Person> list(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Person> list(Pageable pageable);
	
	/**
	 * Finds person by id.
	 * 
	 * @param id
	 *            The id of the wanted person.
	 * @return The found person. If no person is found, this method returns
	 *         null.
	 */
	public Person findById(Long id) throws EntityNotFoundException;

	/**
	 * Updates the information of a person.
	 * 
	 * @param updated
	 *            The information of the updated person.
	 * @return The updated person.
	 * @throws EntityNotFoundException
	 *             if no person is found with given id.
	 */
	public Person update(Person updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the persons in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the person.
	 */

	public long countAll();
	
}

