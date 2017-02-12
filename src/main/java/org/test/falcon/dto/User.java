package org.test.falcon.dto;

import java.io.Serializable;

//@Entity
//@Table(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id = 21;
	
	private String userName = "admin";
	
	private String password = "admin";
	
	private String deviceId = "UNQDEV-1";
	
	private String projectName = "";
	
	private Double sanctionedLoad = 3.5;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Double getSanctionedLoad() {
		return sanctionedLoad;
	}

	public void setSanctionedLoad(Double sanctionedLoad) {
		this.sanctionedLoad = sanctionedLoad;
	}
	
	
}
