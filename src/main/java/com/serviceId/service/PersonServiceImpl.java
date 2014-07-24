package com.serviceId.service;

// Generated 4 Jun, 2014 11:33:30 AM

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviceId.Person;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * ServiceImpl object for domain model class Person.
 * @see com.serviceId.Person
 */

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    
	   
    private  WMGenericDao<Person, Long> personRepository;

    @Transactional
    public Person create(Person person) {
        LOGGER.debug("Creating a new person with information: {}" , person);
        return personRepository.create(person);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Person delete(Long personId) throws EntityNotFoundException {
        LOGGER.debug("Deleting person with id: {}" , personId);
        Person deleted = personRepository.findById(personId);
        if (deleted == null) {
            LOGGER.debug("No person found with id: {}" , personId);
            throw new EntityNotFoundException(personId.toString());
        }
        personRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public Page<Person> list(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all persons");
        return personRepository.search(queryFilters,
					pageable);
		
    }
    
    @Transactional(readOnly = true)
    public Page<Person> list(Pageable pageable) {
        LOGGER.debug("Finding all persons");
        return personRepository.list(pageable);
    }

    @Transactional(readOnly = true)
    public Person findById(Long id) throws EntityNotFoundException {
        LOGGER.debug("Finding person by id: {}" , id);
        Person person=personRepository.findById(id);
        if(person==null){
            LOGGER.debug("No person found with id: {}" , id);
            throw new EntityNotFoundException(id.toString());
        }
        return person;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Person update(Person updated) throws EntityNotFoundException {
        LOGGER.debug("Updating person with information: {}" , updated);
        Person person = null;
        person = personRepository.findById((Long)updated.getPId()); 
        LOGGER.debug("Found person: {}" , person);
        
        if (person == null) {
            LOGGER.debug("No person found with id: {}" , updated.getPId());
            throw new EntityNotFoundException(updated.getPId().toString());
        }
        personRepository.update(updated);

        return person;
    }


    protected void setPersonRepository(WMGenericDao<Person, Long> personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public long countAll() {
        return personRepository.count();
    }

	

}

