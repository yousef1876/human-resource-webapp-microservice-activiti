package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "product_catogery")
public class ProductCatogery {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "catogery_id", updatable = false, nullable = false)
	private Long id;
	
	private  String catogery;

}
