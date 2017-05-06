package org.test.falcon.mongo.document;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@Document(collection = "feed")
public class ChildDevice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Field(value = "child_id")
	private String uniqId;
	
	@Field(value = "readings")
	private Map<String, String> readings;

	public String getUniqId() {
		return uniqId;
	}

	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	public Map<String, String> getReadings() {
		return readings;
	}

	public void setReadings(Map<String, String> readings) {
		this.readings = readings;
	}
}
