package com.serviceId;
// Generated 4 Jun, 2014 11:33:29 AM by Hibernate Tools 4.3.1


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Orders generated by hbm2java
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@Entity
@Table(name="orders"
)
public class Orders implements java.io.Serializable {


     private Long id;
     private Address addressByShippingAddressId;
     private Address addressByBillingAddressId;
     private Customer customer;
     private Set<Lineitem> lineitems = new HashSet<Lineitem>(0);

    public Orders() {
    }

	
    public Orders(Address addressByShippingAddressId, Customer customer) {
        this.addressByShippingAddressId = addressByShippingAddressId;
        this.customer = customer;
    }
    public Orders(Address addressByShippingAddressId, Address addressByBillingAddressId, Customer customer, Set<Lineitem> lineitems) {
       this.addressByShippingAddressId = addressByShippingAddressId;
       this.addressByBillingAddressId = addressByBillingAddressId;
       this.customer = customer;
       this.lineitems = lineitems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="shippingAddress_id", nullable=false)
    public Address getAddressByShippingAddressId() {
        return this.addressByShippingAddressId;
    }
    
    public void setAddressByShippingAddressId(Address addressByShippingAddressId) {
        this.addressByShippingAddressId = addressByShippingAddressId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="billingAddress_id")
    public Address getAddressByBillingAddressId() {
        return this.addressByBillingAddressId;
    }
    
    public void setAddressByBillingAddressId(Address addressByBillingAddressId) {
        this.addressByBillingAddressId = addressByBillingAddressId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonIgnore
@OneToMany(fetch=FetchType.EAGER, mappedBy="orders")
    public Set<Lineitem> getLineitems() {
        return this.lineitems;
    }
    
    public void setLineitems(Set<Lineitem> lineitems) {
        this.lineitems = lineitems;
    }


	@Override
	public String toString() {
		return "Orders [id=" + id + ", addressByShippingAddressId="
				+ addressByShippingAddressId + ", addressByBillingAddressId="
				+ addressByBillingAddressId + ", customer=" + customer
				+ ", lineitems=" + lineitems + "]";
	}




}


