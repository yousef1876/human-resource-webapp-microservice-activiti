package com.hr.framework.param;

import com.hr.framework.annotation.NotNullField;
import com.hr.framework.annotation.SizeField;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpMethod;

/**
 * Param bean for {@link com.hr.framework.domain.UserDomain}
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 9/22/15
 * @since JDK1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParam extends BaseParam {

  private static final long serialVersionUID = -9153801716112918626L;

  
  
  @NotNullField(method = {HttpMethod.PUT, HttpMethod.DELETE}, message = "id cannot be null.")
  private Long id;

  @ApiModelProperty(value = "username", required = true, notes = "usr must greater than or equal to 4 and less than or equal to 50.")
  @NotNullField(method = HttpMethod.POST, message = "usr cannot be null.")
  @SizeField(min = 4, max = 50, method = HttpMethod.POST, message = "usr must greater than or equal to 4 and less than or equal to 50.")
  private String usr; // username

  @ApiModelProperty(value = "password", required = true, notes = "pwd must greater than or equal to 4 and less than or equal to 16.")
  @NotNullField(method = HttpMethod.POST, message = "pwd cannot be null.")
  @SizeField(min = 4, max = 16, method = HttpMethod.POST, message = "pwd must greater than or equal to 4 and less than or equal to 16.")
  private String pwd; // password

  @ApiModelProperty(value = "user's name")
  private String name; // user's name

  private String description;

  @ApiModelProperty(value = "ids of roles", example = "1,2,3", notes = "separated by comma and no space.")
  private String roleIds; // role ids string

  public UserParam(String usr) {
    this.usr = usr;
  }

  /* public UserParam() {
		
  }*/
  
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsr() {
	return usr;
}

public void setUsr(String usr) {
	this.usr = usr;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
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

public String getRoleIds() {
	return roleIds;
}

public void setRoleIds(String roleIds) {
	this.roleIds = roleIds;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
}
