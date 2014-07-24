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

import com.serviceId.Lineitem;
import com.serviceId.service.LineitemService;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;

/**
 * Controller object for domain model class Lineitem.
 * @see com.serviceId.Lineitem
 */

@RestController
@RequestMapping("/serviceId/lineitem")
public class LineitemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LineitemController.class);

	@Autowired
	private LineitemService service;

	/**
	 * Processes requests to return lists all available Lineitems.
	 * 
	 * @param model
	 * @return The name of the  Lineitem list view.
	 */
	 
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Page<Lineitem> list(
			@RequestBody QueryFilter[] queryFilters,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Lineitems list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(queryFilters, pageable);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Page<Lineitem> getLineitems(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size) {
		LOGGER.debug("Rendering Lineitems list");
		Pageable pageable = new PageRequest(page - 1, size);
		return service.list(pageable);
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Long countAll() {
		LOGGER.debug("counting Lineitems");
		Long count = service.countAll();
		return count;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Lineitem getLineitem(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Getting person with id: {}" , id);
		Lineitem instance = service.findById(id);
		LOGGER.debug("Lineitem details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		LOGGER.debug("Deleting Lineitem with id: {}" , id);
		Lineitem deleted = service.delete(id);
		return deleted != null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Lineitem editLineitem(@PathVariable("id") Long id, @RequestBody Lineitem instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Lineitem with id: {}" , instance.getId());
        instance.setId(id);
		instance = service.update(instance);
		LOGGER.debug("Lineitem details with id: {}" , instance);
		return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createLineitem(@RequestBody Lineitem instance) {
		LOGGER.debug("Create Lineitem with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Lineitem with information: {}" , instance);
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
	protected void setLineitemService(LineitemService service) {
		this.service = service;
	}
}

