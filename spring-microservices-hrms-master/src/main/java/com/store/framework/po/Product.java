package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", updatable = false, nullable = false)
	private Long id;
	
	private String metaKeyword;
	
	private String fullDescription;
	
	private String metaTitle;
	
	private String name;
	
	private String manufacturerPartNumber;
	
	private String price;
	
	private String oldPrice;
	
	private String maxPrice;
	
	private String length;
	
	private String width;
	
	private String height;
	
	private String specialPrice;
	
	private String discount;
	
	private String maxLength;
	
	
	private String maxWidth;
	
	private String maxHeight;
	
	
	/* Catogery Product FK*/
	
	/* Store FK */
	
	/*Quantity Unity*/
	
	/* Quality FK*/

}
