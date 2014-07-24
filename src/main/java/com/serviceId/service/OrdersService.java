package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serviceId.Orders;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * Service object for domain model class Orders.
 * @see com.serviceId.Orders
 */

public interface OrdersService {

   /**
	 * Creates a new orders.
	 * 
	 * @param created
	 *            The information of the created orders.
	 * @return The created orders.
	 */
	public Orders create(Orders created);

	/**
	 * Deletes a orders.
	 * 
	 * @param ordersId
	 *            The id of the deleted orders.
	 * @return The deleted orders.
	 * @throws EntityNotFoundException
	 *             if no orders is found with the given id.
	 */
	public Orders delete(Long ordersId) throws EntityNotFoundException;

	/**
	 * Finds all orderss.
	 * 
	 * @return A list of orderss.
	 */
	public Page<Orders> list(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Orders> list(Pageable pageable);
	
	/**
	 * Finds orders by id.
	 * 
	 * @param id
	 *            The id of the wanted orders.
	 * @return The found orders. If no orders is found, this method returns
	 *         null.
	 */
	public Orders findById(Long id) throws EntityNotFoundException;

	/**
	 * Updates the information of a orders.
	 * 
	 * @param updated
	 *            The information of the updated orders.
	 * @return The updated orders.
	 * @throws EntityNotFoundException
	 *             if no orders is found with given id.
	 */
	public Orders update(Orders updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the orderss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the orders.
	 */

	public long countAll();
}

