package com.hr.framework.vo;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO implements Serializable {

  private static final long serialVersionUID = 1444065316565469644L;
  private Long id;
  private String name;
  private String description;
  private Set<ResourceVO> resources;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Set<ResourceVO> getResources() {
	return resources;
}
public void setResources(Set<ResourceVO> resources) {
	this.resources = resources;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
  
}
