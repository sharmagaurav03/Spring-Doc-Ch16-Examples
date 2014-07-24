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
import com.serviceId.Lineitem;
import com.serviceId.repository.LineitemRepository;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * ServiceImpl object for domain model class Lineitem.
 * @see com.serviceId.Lineitem
 */

@Service
public class LineitemServiceImpl implements LineitemService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LineitemServiceImpl.class);
    
    @Resource
    private WMGenericDao<Lineitem, Long> lineitemRepository;

    @Transactional
    
    public Lineitem create(Lineitem lineitem) {
        LOGGER.debug("Creating a new lineitem with information: {}" , lineitem);
        return lineitemRepository.create(lineitem);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Lineitem delete(Long lineitemId) throws EntityNotFoundException {
        LOGGER.debug("Deleting lineitem with id: {}" , lineitemId);
        Lineitem deleted = lineitemRepository.findById(lineitemId);
        if (deleted == null) {
            LOGGER.debug("No lineitem found with id: {}" , lineitemId);
            throw new EntityNotFoundException(lineitemId.toString());
        }
        lineitemRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    
    public Page<Lineitem> list(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all lineitems");
        return lineitemRepository.search(queryFilters,
					pageable);
		
    }
    
    @Transactional(readOnly = true)
    
    public Page<Lineitem> list(Pageable pageable) {
        LOGGER.debug("Finding all lineitems");
        return lineitemRepository.list(pageable);
    }

    @Transactional(readOnly = true)
    
    public Lineitem findById(Long id) throws EntityNotFoundException {
        LOGGER.debug("Finding lineitem by id: {}" , id);
        Lineitem lineitem=lineitemRepository.findById(id);
        if(lineitem==null){
            LOGGER.debug("No lineitem found with id: {}" , id);
            throw new EntityNotFoundException(id.toString());
        }
        return lineitem;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Lineitem update(Lineitem updated) throws EntityNotFoundException {
        LOGGER.debug("Updating lineitem with information: {}" , updated);
        Lineitem lineitem = null;
        lineitem = lineitemRepository.findById((Long)updated.getId()); 
        LOGGER.debug("Found lineitem: {}" , lineitem);
        
        if (lineitem == null) {
            LOGGER.debug("No lineitem found with id: {}" , updated.getId());
            throw new EntityNotFoundException(updated.getId().toString());
        }
        lineitemRepository.update(updated);

        return lineitem;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param lineitemRepository
     */
    protected void setLineitemRepository(LineitemRepository lineitemRepository) {
        this.lineitemRepository = lineitemRepository;
    }

    @Transactional(readOnly = true)
    
    public long countAll() {
        return lineitemRepository.count();
    }
    
}

