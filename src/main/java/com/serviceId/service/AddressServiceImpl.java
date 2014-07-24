package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviceId.Address;
import com.serviceId.repository.AddressRepository;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * ServiceImpl object for domain model class Address.
 * @see com.serviceId.Address
 */

@Service(value="addressService")
public class AddressServiceImpl implements AddressService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
    
    @Autowired
    private WMGenericDao<Address, Long>  addressRepository;

    @Transactional
    public Address create(Address address) {
        LOGGER.debug("Creating a new address with information: {}" , address);
        return addressRepository.create(address);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Address delete(Long addressId) throws EntityNotFoundException {
        LOGGER.debug("Deleting address with id: {}" , addressId);
        Address deleted = addressRepository.findById(addressId);
        if (deleted == null) {
            LOGGER.debug("No address found with id: {}" , addressId);
            throw new EntityNotFoundException(addressId.toString());
        }
        addressRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public Page<Address> list(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all addresss");
        return addressRepository.search(queryFilters,
					pageable);
		
    }
    
    @Transactional(readOnly = true)
    public Page<Address> list(Pageable pageable) {
        LOGGER.debug("Finding all addresss");
        return addressRepository.list(pageable);
    }

    @Transactional(readOnly = true)
    public Address findById(Long id) throws EntityNotFoundException {
        LOGGER.debug("Finding address by id: {}" , id);
        Address address=addressRepository.findById(id);
        if(address==null){
            LOGGER.debug("No address found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return address;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Address update(Address updated) throws EntityNotFoundException {
        LOGGER.debug("Updating address with information: {}" , updated);
        Address address = null;
        address = addressRepository.findById((Long)updated.getPId()); 
        LOGGER.debug("Found address: {}" , address);
        
        if (address == null) {
            LOGGER.debug("No address found with id: {}" , updated.getPId());
            throw new EntityNotFoundException(updated.getPId().toString());
        }
        addressRepository.update(updated);

        return address;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param addressRepository
     */
    protected void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional(readOnly = true)
    public long countAll() {
        return addressRepository.count();
    }

}

