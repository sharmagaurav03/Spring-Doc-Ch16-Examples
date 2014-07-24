package com.serviceId.controller; 

// Generated 4 Jun, 2014 11:33:30 AM


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.serviceId.Customer;
import com.serviceId.service.CustomerService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;

/**
 * Controller object for domain model class Customer.
 * @see com.serviceId.Customer
 */

@RestController
@RequestMapping("/serviceId/customer")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;

	/**
	 * Processes requests to return lists all available Customers.
	 * 
	 * @param model
	 * @return The name of the  Customer list view.
	 */
	 
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Page<Customer> list(
			@RequestBody QueryFilter[] queryFilters,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Customers list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(queryFilters, pageable);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Page<Customer> getCustomers(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Customers list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(pageable);
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Long countAll() {
		LOGGER.debug("counting Customers");
		Long count = service.countAll();
		return count;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Getting person with id: {}" , id);
		Customer instance = service.findById(id);
		LOGGER.debug("Customer details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Deleting Customer with id: {}" , id);
		Customer deleted = service.delete(id);
		return deleted != null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Customer editCustomer(@PathVariable("id") Long id, @RequestBody Customer instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Customer with id: {}" , instance.getPId());
        instance.setPId(id);
		instance = service.update(instance);
		LOGGER.debug("Customer details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer instance) {
		LOGGER.debug("Create Customer with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Customer with information: {}" , instance);
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
	protected void setCustomerService(CustomerService service) {
		this.service = service;
	}
}

