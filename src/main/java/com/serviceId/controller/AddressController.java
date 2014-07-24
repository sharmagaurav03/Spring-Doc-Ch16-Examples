package com.serviceId.controller; 

// Generated 4 Jun, 2014 11:33:30 AM


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serviceId.Address;
import com.serviceId.service.AddressService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;

/**
 * Controller object for domain model class Address.
 * @see com.serviceId.Address
 */

@RestController
@RequestMapping("/serviceId/address")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService service;

	/**
	 * Processes requests to return lists all available Addresss.
	 * 
	 * @param model
	 * @return The name of the  Address list view.
	 */
	 
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Page<Address> list(
			@RequestBody QueryFilter[] queryFilters,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Addresss list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(queryFilters, pageable);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Page<Address> getAddresss(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Addresss list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(pageable);
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Long countAll() {
		LOGGER.debug("counting Addresss");
		Long count = service.countAll();
		return count;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Address getAddress(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Getting person with id: {}" , id);
		Address instance = service.findById(id);
		LOGGER.debug("Address details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Deleting Address with id: {}" , id);
		Address deleted = service.delete(id);
		return deleted != null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Address editAddress(@PathVariable("id") Long id, @RequestBody Address instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Address with id: {}" , instance.getPId());
        instance.setPId(id);
		instance = service.update(instance);
		LOGGER.debug("Address details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createAddress(@RequestBody Address instance) {
		LOGGER.debug("Create Address with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Address with information: {}" , instance);
	}
	
	/*@org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
	ResponseEntity<String> handleEntityNotFoundException(Exception e) {
		return new ResponseEntity<String>(String.format("{\"Error\":\"%s\"}",
				e.getMessage()), HttpStatus.NOT_FOUND);
	}*/
	
	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setAddressService(AddressService service) {
		this.service = service;
	}
}

