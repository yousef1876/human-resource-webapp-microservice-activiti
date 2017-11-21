package com.hr.framework.param;

import com.hr.framework.annotation.NotNullField;
import com.hr.framework.domain.ClientDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpMethod;

/**
 * Param bean for {@link ClientDomain}
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 10/25/15
 * @since JDK1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientParam extends BaseParam {

  private static final long serialVersionUID = 6065608866944007796L;

  @NotNullField(method = {HttpMethod.PUT, HttpMethod.DELETE}, message = "id cannot be null.")
  private Long id;

  @NotNullField(method = HttpMethod.POST, message = "name cannot be null.")
  private String name;

  @NotNullField(method = HttpMethod.POST, message = "publicKey cannot be null.")
  private String publicKey;

  @NotNullField(method = HttpMethod.POST, message = "scope cannot be null.")
  private String scope;

  @NotNullField(method = HttpMethod.POST, message = "grantType cannot be null.")
  private String grantType;
  private Integer accessTokenValiditySeconds;
  private Integer refreshTokenValiditySeconds;
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
public String getPublicKey() {
	return publicKey;
}
public void setPublicKey(String publicKey) {
	this.publicKey = publicKey;
}
public String getScope() {
	return scope;
}
public void setScope(String scope) {
	this.scope = scope;
}
public String getGrantType() {
	return grantType;
}
public void setGrantType(String grantType) {
	this.grantType = grantType;
}
public Integer getAccessTokenValiditySeconds() {
	return accessTokenValiditySeconds;
}
public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
	this.accessTokenValiditySeconds = accessTokenValiditySeconds;
}
public Integer getRefreshTokenValiditySeconds() {
	return refreshTokenValiditySeconds;
}
public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
	this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

  
  
  
}
