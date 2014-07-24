package com.serviceId.repository; 
// Generated 4 Jun, 2014 11:33:30 AM 

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.serviceId.Product;
import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;
/**
 * Specifies methods used to obtain and modify Product related information
 * which is stored in the database.
 */
public class ProductRepository extends WMGenericDaoImpl<Product, Long>{

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}
	
	public void setTemplate(HibernateTemplate template) {
		this.template=template;
	}

	public String getAttributeName(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

}

