package com.hr.framework.po.transaction.logger;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "role_access_permission")
public class Permissions{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "permission_id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name  = "can_view" , nullable = false)
	private boolean canView;
	
	@Column(name = "can_edit" , nullable = false)
	private boolean canEdit;
	
	@Column(name  = "can_insert" , nullable = false)
	private boolean canInsert;


	@ManyToMany(mappedBy = "permissions")
	private List<Operations> operations;


}
