package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "store_address")
public class StoreAddress {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id", updatable = false, nullable = false)
	private Long id;
	
	
	private String addressName;
	
	private String title;
	
	private String description;
	
	private String note;
	
	/*StoreStreet FK*/
	
	private String buildingName;
	
	private String buildingStreetNumber;
	
	
	/* City FK*/
	
	/*Country FK*/
	
	
	
}
