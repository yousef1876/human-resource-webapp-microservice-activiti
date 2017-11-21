package com.hr.framework.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;

import com.hr.framework.filter.ErrorsDataFields;
import com.hr.framework.po.Client;
import com.hr.framework.po.Log;
import com.hr.framework.po.Log.EntityBuilder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientVO implements Serializable {

  private static final long serialVersionUID = -6088897333280284093L;
  private Long id;
  private String clientId;
  private Set<String> resourceIds;
  private String clientSecret;
  private Set<String> scope;
  private Set<String> authorizedGrantTypes;
  private Set<String> registeredRedirectUri;
  private Integer accessTokenValiditySeconds;
  private Integer refreshTokenValiditySeconds;
  private Collection<GrantedAuthority> grantedAuthorities;
  private String publicKey;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getClientId() {
	return clientId;
}
public void setClientId(String clientId) {
	this.clientId = clientId;
}
public Set<String> getResourceIds() {
	return resourceIds;
}
public void setResourceIds(Set<String> resourceIds) {
	this.resourceIds = resourceIds;
}
public String getClientSecret() {
	return clientSecret;
}
public void setClientSecret(String clientSecret) {
	this.clientSecret = clientSecret;
}
public Set<String> getScope() {
	return scope;
}
public void setScope(Set<String> scope) {
	this.scope = scope;
}
public Set<String> getAuthorizedGrantTypes() {
	return authorizedGrantTypes;
}
public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
	this.authorizedGrantTypes = authorizedGrantTypes;
}
public Set<String> getRegisteredRedirectUri() {
	return registeredRedirectUri;
}
public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
	this.registeredRedirectUri = registeredRedirectUri;
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
public Collection<GrantedAuthority> getGrantedAuthorities() {
	return grantedAuthorities;
}
public void setGrantedAuthorities(
		Collection<GrantedAuthority> grantedAuthorities) {
	this.grantedAuthorities = grantedAuthorities;
}
public String getPublicKey() {
	return publicKey;
}
public void setPublicKey(String publicKey) {
	this.publicKey = publicKey;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
public static class EntityBuilder{
    
	
	
	/*  id , clientId , clientSecret ,  resourceIds ,  scope ,  authorizedGrantTypes , registeredRedirectUri , grantedAuthorities , map , accessTokenValiditySeconds , refreshTokenValiditySeconds , publicKey*/
    private ErrorsDataFields body;
    
    private static Long id;
    private static  String clientId;
    private  static String resourceIds;
    private static String clientSecret;
    private static String scope;
    private static String authorizedGrantTypes;
    private static String registeredRedirectUri;
    private static Integer accessTokenValiditySeconds;
    private static Integer refreshTokenValiditySeconds;
    private static Collection<GrantedAuthority> grantedAuthorities;
    private static String publicKey;
    
   
    
    public EntityBuilder(long id , String clientId , String resourceIds , String clientSecret , String scope 
    		, String authorizedGrantTypes , String registeredRedirectUri
    		, Integer accessTokenValiditySeconds , Integer refreshTokenValiditySeconds
    		) {
    	this.id = id;
    	this.clientId = clientId;
    	this.resourceIds = resourceIds;
    	this.clientSecret = clientSecret;
    	this.scope = scope;
    	this.authorizedGrantTypes = authorizedGrantTypes;
    	this.registeredRedirectUri = registeredRedirectUri;
    	this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    	this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    	this.publicKey = publicKey;
    	
    }

    public EntityBuilder( ) {
    
    }
    
    public  ClientVO.EntityBuilder  id(long error) {
        
        return new EntityBuilder();
    }

    public  ClientVO.EntityBuilder clientId(String clientId) {
      
    	return new EntityBuilder();
    }
    
    public  ClientVO.EntityBuilder resourceIds(Set resourceIds) {
        
      	return new EntityBuilder();
    }
    
    public  ClientVO.EntityBuilder clientSecret(String clientSecret) {
        
    	return new EntityBuilder();
    }
    
    public  ClientVO.EntityBuilder scope(Set scope) {
        
      	return new EntityBuilder();
    }
    public  ClientVO.EntityBuilder authorizedGrantTypes(Set authorizedGrantTypes) {
        
      	return new EntityBuilder();
    }
    
    public  ClientVO.EntityBuilder registeredRedirectUri(Set registeredRedirectUri) {
        
      	return new EntityBuilder();
    }
    public  ClientVO.EntityBuilder accessTokenValiditySeconds(int accessTokenValiditySeconds) {
        
      	return new EntityBuilder();
    }
   public  ClientVO.EntityBuilder refreshTokenValiditySeconds(int accessTokenValiditySeconds) {
        
      	return new EntityBuilder();
    }
    
   public  ClientVO.EntityBuilder publicKey(String publicKey) {
       
     	return new EntityBuilder();
   }
   public  ClientVO.EntityBuilder grantedAuthorities(List accessTokenValiditySeconds) { 
	   return new EntityBuilder();
   }
    public ClientVO build() {
        return new ClientVO();
    }

    public static ClientVO.EntityBuilder builder(){
    	return new EntityBuilder(id, clientId , resourceIds , clientSecret ,scope  , authorizedGrantTypes , registeredRedirectUri , accessTokenValiditySeconds , refreshTokenValiditySeconds);
    }
    
    public String toString() {
        return "de.rpr.EntityBuilder(usr=[" + id + "],clientId=[" + clientId+"],clientSecret=["+clientSecret+"],scope=["+scope+"],authorizedGrantTypes=["+authorizedGrantTypes+"],authorizedGrantTypes=["+registeredRedirectUri+"])";
    }
}
  
}
