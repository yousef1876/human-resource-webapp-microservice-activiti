package com.hr.framework.po.bug.tracking.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups_bugs")
public class Groups {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "group_name" , nullable = false)
	private String groupName;
	
	@Column(name = "is_active" , nullable = false)
	private boolean isActive = true;
	
	@Column(name = "deleted" , nullable = false)
	private boolean deleted = false;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
