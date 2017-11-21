package com.store.framework.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", updatable = false, nullable = false)
	private Long id;
	
	private String firstName;
	
	private String secondName;
	
	private String lastName;
	
	
    private String mobileNumber;
    
    
    private String phoneNumber;
    
    
    private String email;
    
    
    /* Address FK*/
    
    /* Address FK  */
    
    private String idCard;
    
    
    private String passport;
	

}
