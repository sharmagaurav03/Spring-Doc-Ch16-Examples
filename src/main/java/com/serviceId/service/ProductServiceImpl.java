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
import com.serviceId.Product;
import com.serviceId.repository.ProductRepository;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
/**
 * ServiceImpl object for domain model class Product.
 * @see com.serviceId.Product
 */

@Service
public class ProductServiceImpl implements ProductService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Resource
    private WMGenericDao<Product, Long>  productRepository;

    @Transactional
    
    public Product create(Product product) {
        LOGGER.debug("Creating a new product with information: {}" , product);
        return productRepository.create(product);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Product delete(Long productId) throws EntityNotFoundException {
        LOGGER.debug("Deleting product with id: {}" , productId);
        Product deleted = productRepository.findById(productId);
        if (deleted == null) {
            LOGGER.debug("No product found with id: {}" , productId);
            throw new EntityNotFoundException(productId.toString());
        }
        productRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    
    public Page<Product> list(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all products");
        return productRepository.search(queryFilters,
					pageable);
		
    }
    
    @Transactional(readOnly = true)
    
    public Page<Product> list(Pageable pageable) {
        LOGGER.debug("Finding all products");
        return productRepository.list(pageable);
    }

    @Transactional(readOnly = true)
    
    public Product findById(Long id) throws EntityNotFoundException {
        LOGGER.debug("Finding product by id: {}" , id);
        Product product=productRepository.findById(id);
        if(product==null){
            LOGGER.debug("No product found with id: {}" , id);
            throw new EntityNotFoundException(id.toString());
        }
        return product;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    
    public Product update(Product updated) throws EntityNotFoundException {
        LOGGER.debug("Updating product with information: {}" , updated);
        Product product = null;
        product = productRepository.findById((Long)updated.getId()); 
        LOGGER.debug("Found product: {}" , product);
        
        if (product == null) {
            LOGGER.debug("No product found with id: {}" , updated.getId());
            throw new EntityNotFoundException(updated.getId().toString());
        }
        productRepository.update(updated);

        return product;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param productRepository
     */
    protected void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    
    public long countAll() {
        return productRepository.count();
    }
    
}

