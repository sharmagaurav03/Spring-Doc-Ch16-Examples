package com.serviceId.service;
// Generated 4 Jun, 2014 11:33:30 AM

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviceId.Orders;
import com.serviceId.repository.OrdersRepository;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * ServiceImpl object for domain model class Orders.
 * @see com.serviceId.Orders
 */

@Service
public class OrdersServiceImpl implements OrdersService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);
    
    @Resource
    private WMGenericDao<Orders, Long> ordersRepository;

    @Transactional
    
    public Orders create(Orders orders) {
        LOGGER.debug("Creating a new orders with information: {}" , orders);
        return ordersRepository.create(orders);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Orders delete(Long ordersId) throws EntityNotFoundException {
        LOGGER.debug("Deleting orders with id: {}" , ordersId);
        Orders deleted = ordersRepository.findById(ordersId);
        if (deleted == null) {
            LOGGER.debug("No orders found with id: {}" , ordersId);
            throw new EntityNotFoundException(ordersId.toString());
        }
        ordersRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    
    public Page<Orders> list(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all orderss");
        return ordersRepository.search(queryFilters,
					pageable);
		
    }
    
    @Transactional(readOnly = true)
    
    public Page<Orders> list(Pageable pageable) {
        LOGGER.debug("Finding all orderss");
        return ordersRepository.list(pageable);
    }

    @Transactional(readOnly = true)
    
    public Orders findById(Long id) throws EntityNotFoundException {
        LOGGER.debug("Finding orders by id: {}" , id);
        Orders orders=ordersRepository.findById(id);
        if(orders==null){
            LOGGER.debug("No orders found with id: {}" , id);
            throw new EntityNotFoundException(id.toString());
        }
        return orders;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Orders update(Orders updated) throws EntityNotFoundException {
        LOGGER.debug("Updating orders with information: {}" , updated);
        Orders orders = null;
        orders = ordersRepository.findById((Long)updated.getId()); 
        LOGGER.debug("Found orders: {}" , orders);
        
        if (orders == null) {
            LOGGER.debug("No orders found with id: {}" , updated.getId());
            throw new EntityNotFoundException(updated.getId().toString());
        }
        ordersRepository.update(updated);

        return orders;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param ordersRepository
     */
    protected void setOrdersRepository(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Transactional(readOnly = true)
    
    public long countAll() {
        return ordersRepository.count();
    }
    
}

