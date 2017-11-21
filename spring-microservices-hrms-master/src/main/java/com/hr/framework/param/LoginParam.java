package com.hr.framework.param;

import com.hr.framework.annotation.NotNullField;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpMethod;

/**
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 15/02/2017
 * @since JDK1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam implements Serializable {

  private static final long serialVersionUID = 1148462952236125805L;

  @NotNullField(method = HttpMethod.POST, message = "usr cannot be null.")
  @Size(min = 4, max = 50, message = "usr must greater than or equal to 4 and less than or equal to 50.")
  private String usr;

  @NotNullField(method = HttpMethod.POST, message = "pwd cannot be null.")
  @Size(min = 4, max = 16, message = "pwd must greater than or equal to 4 and less than or equal to 16.")
  private String pwd;

  @NotNullField(method = HttpMethod.PUT, message = "refresh token cannot be null.")
  private String refreshToken;

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

public String getRefreshToken() {
	return refreshToken;
}

public void setRefreshToken(String refreshToken) {
	this.refreshToken = refreshToken;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
  
}
