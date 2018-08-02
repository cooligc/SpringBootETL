/**
 * 
 */
package com.cooligc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sitakant
 *
 */
@Entity
@Table(name="META_DATA")
public class Meta {

	@Id
	@GeneratedValue
	private Long id;
	
	private String authToken;

	/**
	 * @return the authToken
	 */
	public String getAuthToken() {
		return authToken;
	}

	/**
	 * @param authToken the authToken to set
	 */
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	
}
