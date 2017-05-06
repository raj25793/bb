package org.test.falcon.dto;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Field;
import org.test.falcon.mongo.document.LocationPoint;

public class LeadDto {
	
	private String name;
	
	private String address;
	
	private String landmark;
	
	private LocationPoint<GeoJsonPoint> locationPoint;
	
	private String city;
	
	private String state;
	
	private String phone;
	
	private String emailId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public LocationPoint<GeoJsonPoint> getLocationPoint() {
		return locationPoint;
	}

	public void setLocationPoint(LocationPoint<GeoJsonPoint> locationPoint) {
		this.locationPoint = locationPoint;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
