package com.hr.framework.vo;

import java.io.Serializable;

import javax.persistence.Entity;

import com.hr.framework.filter.ErrorsDataFields;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public  class ErrorVO implements Serializable {

	private static final long serialVersionUID = -7144407219523712074L;
	public static String error;
	public String error_description;

	/*public ErrorVO(String error) {
		this.error = error;
	}*/

	public ErrorVO(String error , String description) {
		this.error = error;
	    this.error_description = description ;
	}
	

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 public static class EntityBuilder{
	        
	        private ErrorsDataFields body;
	        
	        private static String error;
	        private static String description ;
	        
	        public EntityBuilder(String error , String description) {
	        	this.error = error;
	        	this.description = description;
	        }
	 
	        public EntityBuilder( ) {
	        
	        }
	        
	        public static ErrorVO.EntityBuilder  error(String error) {
	            
	            return new EntityBuilder();
	        }
	 
	        public static ErrorVO.EntityBuilder description(String description) {
	          
	        	return new EntityBuilder();
	        }
	        
	        
	        public  ErrorVO build() {
	            return new ErrorVO(error , description);
	        }
	 
	        public ErrorVO.EntityBuilder builder(){
	        	return new EntityBuilder(error, description);
	        }
	        
	        public String toString() {
	            return "de.rpr.EntityBuilder(body=[" + error + "],description=[" + description+")";
	        }
	    }

}
