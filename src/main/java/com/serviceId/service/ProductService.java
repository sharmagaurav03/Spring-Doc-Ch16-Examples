package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serviceId.Product;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * Service object for domain model class Product.
 * @see com.serviceId.Product
 */

public interface ProductService {

   /**
	 * Creates a new product.
	 * 
	 * @param created
	 *            The information of the created product.
	 * @return The created product.
	 */
	public Product create(Product created);

	/**
	 * Deletes a product.
	 * 
	 * @param productId
	 *            The id of the deleted product.
	 * @return The deleted product.
	 * @throws EntityNotFoundException
	 *             if no product is found with the given id.
	 */
	public Product delete(Long productId) throws EntityNotFoundException;

	/**
	 * Finds all products.
	 * 
	 * @return A list of products.
	 */
	public Page<Product> list(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Product> list(Pageable pageable);
	
	/**
	 * Finds product by id.
	 * 
	 * @param id
	 *            The id of the wanted product.
	 * @return The found product. If no product is found, this method returns
	 *         null.
	 */
	public Product findById(Long id) throws EntityNotFoundException;

	/**
	 * Updates the information of a product.
	 * 
	 * @param updated
	 *            The information of the updated product.
	 * @return The updated product.
	 * @throws EntityNotFoundException
	 *             if no product is found with given id.
	 */
	public Product update(Product updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the products in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the product.
	 */

	public long countAll();
}

