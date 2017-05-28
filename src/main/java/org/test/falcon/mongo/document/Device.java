package org.test.falcon.mongo.document;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.test.falcon.mongo.Enum.DeviceType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Device {

	@Id
	private String deviceId;
	
	@Field(value = "type")
	private DeviceType type;
	
	@Field(value = "cds")
	private List<ChildDevice> childDevices;
	
	@Field(value = "created_at")
	private Date createdAt;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public DeviceType getType() {
		return type;
	}

	public void setType(DeviceType type) {
		this.type = type;
	}

	public List<ChildDevice> getChildDevices() {
		return childDevices;
	}

	public void setChildDevices(List<ChildDevice> childDevices) {
		this.childDevices = childDevices;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
