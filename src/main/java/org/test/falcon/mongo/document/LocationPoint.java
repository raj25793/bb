package org.test.falcon.mongo.document;

import org.springframework.data.mongodb.core.mapping.Field;

public class LocationPoint<T> {
	
	@Field(value = "name")
	private String name;
	
	@Field(value = "geo")
	private T geometry;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getGeometry() {
		return geometry;
	}

	public void setGeometry(T geometry) {
		this.geometry = geometry;
	}
	

}
