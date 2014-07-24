package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serviceId.Lineitem;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * Service object for domain model class Lineitem.
 * @see com.serviceId.Lineitem
 */

public interface LineitemService {

   /**
	 * Creates a new lineitem.
	 * 
	 * @param created
	 *            The information of the created lineitem.
	 * @return The created lineitem.
	 */
	public Lineitem create(Lineitem created);

	/**
	 * Deletes a lineitem.
	 * 
	 * @param lineitemId
	 *            The id of the deleted lineitem.
	 * @return The deleted lineitem.
	 * @throws EntityNotFoundException
	 *             if no lineitem is found with the given id.
	 */
	public Lineitem delete(Long lineitemId) throws EntityNotFoundException;

	/**
	 * Finds all lineitems.
	 * 
	 * @return A list of lineitems.
	 */
	public Page<Lineitem> list(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Lineitem> list(Pageable pageable);
	
	/**
	 * Finds lineitem by id.
	 * 
	 * @param id
	 *            The id of the wanted lineitem.
	 * @return The found lineitem. If no lineitem is found, this method returns
	 *         null.
	 */
	public Lineitem findById(Long id) throws EntityNotFoundException;

	/**
	 * Updates the information of a lineitem.
	 * 
	 * @param updated
	 *            The information of the updated lineitem.
	 * @return The updated lineitem.
	 * @throws EntityNotFoundException
	 *             if no lineitem is found with given id.
	 */
	public Lineitem update(Lineitem updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the lineitems in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the lineitem.
	 */

	public long countAll();
}

