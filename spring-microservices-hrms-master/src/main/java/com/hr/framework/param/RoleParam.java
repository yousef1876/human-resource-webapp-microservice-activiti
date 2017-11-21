package com.hr.framework.param;

import com.hr.framework.annotation.NotNullField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpMethod;

/**
 * Param bean for {@link com.hr.framework.domain.RoleDomain}
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 10/16/15
 * @since JDK1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleParam extends BaseParam {

  private static final long serialVersionUID = 5027600216405994820L;

  @NotNullField(method = {HttpMethod.PUT, HttpMethod.DELETE}, message = "id cannot be null.")
  private Long id;

  @NotNullField(method = HttpMethod.POST, message = "name cannot be null.")
  private String name; // role's name
  private String description;
  private String resourceIds; // group ids string
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
public String getResourceIds() {
	return resourceIds;
}
public void setResourceIds(String resourceIds) {
	this.resourceIds = resourceIds;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
  
}
