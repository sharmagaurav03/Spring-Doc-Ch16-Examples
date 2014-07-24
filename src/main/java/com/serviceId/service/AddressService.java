package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serviceId.Address;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * Service object for domain model class Address.
 * @see com.serviceId.Address
 */

public interface AddressService {

   /**
	 * Creates a new address.
	 * 
	 * @param created
	 *            The information of the created address.
	 * @return The created address.
	 */
	public Address create(Address created);

	/**
	 * Deletes a address.
	 * 
	 * @param addressId
	 *            The id of the deleted address.
	 * @return The deleted address.
	 * @throws EntityNotFoundException
	 *             if no address is found with the given id.
	 */
	public Address delete(Long addressId) throws EntityNotFoundException;

	/**
	 * Finds all addresss.
	 * 
	 * @return A list of addresss.
	 */
	public Page<Address> list(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Address> list(Pageable pageable);
	
	/**
	 * Finds address by id.
	 * 
	 * @param id
	 *            The id of the wanted address.
	 * @return The found address. If no address is found, this method returns
	 *         null.
	 */
	public Address findById(Long id) throws EntityNotFoundException;

	/**
	 * Updates the information of a address.
	 * 
	 * @param updated
	 *            The information of the updated address.
	 * @return The updated address.
	 * @throws EntityNotFoundException
	 *             if no address is found with given id.
	 */
	public Address update(Address updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the addresss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the address.
	 */

	public long countAll();
	
}

