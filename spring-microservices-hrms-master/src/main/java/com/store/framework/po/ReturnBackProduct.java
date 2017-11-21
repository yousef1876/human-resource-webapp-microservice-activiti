package com.store.framework.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "return_back_product")
public class ReturnBackProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id", updatable = false, nullable = false)
	private Long id;
	
	private Date creationDate;
	
	/* Customer FK*/
	
	/* Product FK*/
	
	private String returnPrice;
	
	private String discount;

}
