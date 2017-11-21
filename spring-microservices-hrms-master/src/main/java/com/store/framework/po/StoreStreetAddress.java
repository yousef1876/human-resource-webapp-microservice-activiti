package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "store_street_address")
public class StoreStreetAddress {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "street_id", updatable = false, nullable = false)
	private Long id;
	
	
	private String name;
	
	private String description;
	
	private String note;
	
	private String placeOfInterest;
	
	/* City FK*/
	
	/* Country FK*/
	
	
}
