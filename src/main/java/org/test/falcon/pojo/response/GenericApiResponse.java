package org.test.falcon.pojo.response;

import java.io.Serializable;

import org.test.falcon.constant.ResponseCode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GenericApiResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(value = Include.ALWAYS)
	private Object data;
	
	@JsonInclude(value = Include.ALWAYS)
	private String statusCode;

	public GenericApiResponse(Object data) {
		super();
		this.data = data;
		this.statusCode = ResponseCode.SUCCESS;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
