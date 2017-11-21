package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "quantity_unit")
public class QuantityUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", updatable = false, nullable = false)
	private Long id;
	
	private String description;
	
	private String note;
	
	private String unit;
	
	private String amount;

}
