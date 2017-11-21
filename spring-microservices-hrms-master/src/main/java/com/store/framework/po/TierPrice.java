package com.store.framework.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "tier_price")
public class TierPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "price_id", updatable = false, nullable = false)
	private Long id;
	
	/* product FK*/
	
	/* Customer FK*/
	
	private Date creationDate;
	
 /* CreatedBy FK */
	
	
	private Date deliveryDate;
	
	
	

}
