package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviceId.Customer;
import com.serviceId.repository.CustomerRepository;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * ServiceImpl object for domain model class Customer.
 * @see com.serviceId.Customer
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
    
    @Resource
    private WMGenericDao<Customer, Long> customerRepository;

    @Transactional
    public Customer create(Customer customer) {
        LOGGER.debug("Creating a new customer with information: {}" , customer);
        return customerRepository.create(customer);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Customer delete(Long customerId) throws EntityNotFoundException {
        LOGGER.debug("Deleting customer with id: {}" , customerId);
        Customer deleted = customerRepository.findById(customerId);
        if (deleted == null) {
            LOGGER.debug("No customer found with id: {}" , customerId);
            throw new EntityNotFoundException(customerId.toString());
        }
        customerRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public Page<Customer> list(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all customers");
        return customerRepository.search(queryFilters,
					pageable);
		
    }
    
    @Transactional(readOnly = true)
    public Page<Customer> list(Pageable pageable) {
        LOGGER.debug("Finding all customers");
        return customerRepository.list(pageable);
    }

    @Transactional(readOnly = true)
    
    public Customer findById(Long id) throws EntityNotFoundException {
        LOGGER.debug("Finding customer by id: {}" , id);
        Customer customer=customerRepository.findById(id);
        if(customer==null){
            LOGGER.debug("No customer found with id: {}" , id);
            throw new EntityNotFoundException(id.toString());
        }
        return customer;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Customer update(Customer updated) throws EntityNotFoundException {
        LOGGER.debug("Updating customer with information: {}" , updated);
        Customer customer = null;
        customer = customerRepository.findById((Long)updated.getPId()); 
        LOGGER.debug("Found customer: {}" , customer);
        
        if (customer == null) {
            LOGGER.debug("No customer found with id: {}" , updated.getPId());
            throw new EntityNotFoundException(updated.getPId().toString());
        }
        customerRepository.update(updated);

        return customer;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param customerRepository
     */
    protected void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    
    public long countAll() {
        return customerRepository.count();
    }
    
}

