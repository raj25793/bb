package org.test.falcon.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.test.falcon.mongo.document.LocationPoint;

public class UserDto {
	private String id;
		
	private String userName;
	
	private String email;
	
	private String accountName;
	
	private String category;
	
	private String address;
	
	private LocationPoint<GeoJsonPoint> locationPoint;
	
	private String contactPerson;
	
	private String phone;
	
	private String discom;
	
	private double sancLoad;
	
	private String solrPvSystemType;
	
	private String solrPanelOem;
	
	private String solrPanelSpecification;
	
	private Integer solrPanelQuantity;
	
	private String inverterOem;
	
	private String inverterSpecification;
	
	private Integer inverterQuantity;
	
	private Date commissioningDate;
	
	private List<LeadDto> leadDtos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocationPoint<GeoJsonPoint> getLocationPoint() {
		return locationPoint;
	}

	public void setLocationPoint(LocationPoint<GeoJsonPoint> locationPoint) {
		this.locationPoint = locationPoint;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDiscom() {
		return discom;
	}

	public void setDiscom(String discom) {
		this.discom = discom;
	}

	public double getSancLoad() {
		return sancLoad;
	}

	public void setSancLoad(double sancLoad) {
		this.sancLoad = sancLoad;
	}

	public String getSolrPvSystemType() {
		return solrPvSystemType;
	}

	public void setSolrPvSystemType(String solrPvSystemType) {
		this.solrPvSystemType = solrPvSystemType;
	}

	public String getSolrPanelOem() {
		return solrPanelOem;
	}

	public void setSolrPanelOem(String solrPanelOem) {
		this.solrPanelOem = solrPanelOem;
	}

	public String getSolrPanelSpecification() {
		return solrPanelSpecification;
	}

	public void setSolrPanelSpecification(String solrPanelSpecification) {
		this.solrPanelSpecification = solrPanelSpecification;
	}

	public Integer getSolrPanelQuantity() {
		return solrPanelQuantity;
	}

	public void setSolrPanelQuantity(Integer solrPanelQuantity) {
		this.solrPanelQuantity = solrPanelQuantity;
	}

	public String getInverterOem() {
		return inverterOem;
	}

	public void setInverterOem(String inverterOem) {
		this.inverterOem = inverterOem;
	}

	public String getInverterSpecification() {
		return inverterSpecification;
	}

	public void setInverterSpecification(String inverterSpecification) {
		this.inverterSpecification = inverterSpecification;
	}

	public Integer getInverterQuantity() {
		return inverterQuantity;
	}

	public void setInverterQuantity(Integer inverterQuantity) {
		this.inverterQuantity = inverterQuantity;
	}

	public Date getCommissioningDate() {
		return commissioningDate;
	}

	public void setCommissioningDate(Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public List<LeadDto> getLeadDtos() {
		return leadDtos;
	}

	public void setLeadDtos(List<LeadDto> leadDtos) {
		this.leadDtos = leadDtos;
	}
	
}
