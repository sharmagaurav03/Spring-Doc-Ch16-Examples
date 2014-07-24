package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serviceId.Customer;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * Service object for domain model class Customer.
 * @see com.serviceId.Customer
 */

public interface CustomerService {

   /**
	 * Creates a new customer.
	 * 
	 * @param created
	 *            The information of the created customer.
	 * @return The created customer.
	 */
	public Customer create(Customer created);

	/**
	 * Deletes a customer.
	 * 
	 * @param customerId
	 *            The id of the deleted customer.
	 * @return The deleted customer.
	 * @throws EntityNotFoundException
	 *             if no customer is found with the given id.
	 */
	public Customer delete(Long customerId) throws EntityNotFoundException;

	/**
	 * Finds all customers.
	 * 
	 * @return A list of customers.
	 */
	public Page<Customer> list(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Customer> list(Pageable pageable);
	
	/**
	 * Finds customer by id.
	 * 
	 * @param id
	 *            The id of the wanted customer.
	 * @return The found customer. If no customer is found, this method returns
	 *         null.
	 */
	public Customer findById(Long id) throws EntityNotFoundException;

	/**
	 * Updates the information of a customer.
	 * 
	 * @param updated
	 *            The information of the updated customer.
	 * @return The updated customer.
	 * @throws EntityNotFoundException
	 *             if no customer is found with given id.
	 */
	public Customer update(Customer updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the customers in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the customer.
	 */

	public long countAll();
}

