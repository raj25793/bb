package org.test.falcon.mongo.document;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.test.falcon.enums.DocumentTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@Document(collection = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Field(value = "doc_type")
	private final DocumentTypes docType = DocumentTypes.USER;
	
	@Field(value = "username")
	private String userName;
	
	@Field(value = "email")
	private String email;
	
	@Field(value = "is_registered")
	private boolean isRegistered;
	
	@Field(value = "password")
	private String password;
	
	@Field(value = "acc_name")
	private String accountName;
	
	@Field(value = "cat_id")
	private Integer categoryId;
	
	@Field(value = "address")
	private String address;
	
	@Field(value = "location")
	private LocationPoint<GeoJsonPoint> locationPoint;
	
	@Field(value = "contact_person")
	private String contactPerson;
	
	@Field(value = "phone")
	private String phone;
	
	@Field(value = "discom")
	private Integer discomId;
	
	@Field(value = "sanc_load")
	private double sancLoad;
	
	@Field(value ="solr_type")
	private Integer solrPvSystemTypeId;
	
	@Field(value = "solr_panel_oem")
	private Integer solrPanelOemId;
	
	@Field(value = "solr_spec")
	private String solrPanelSpecification;
	
	@Field(value = "solr_panels")
	private Integer solrPanelQuantity;
	
	@Field(value = "inverter_oem")
	private Integer inverterOemId;
	
	@Field(value = "inverter_spec")
	private String inverterSpecification;
	
	@Field(value= "inverters")
	private Integer inverterQuantity;
	
	@Field(value = "commissioning_date")
	private Date commissioningDate;
	
	@Field(value = "leads")
	private List<Lead> leads;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public Integer getDiscomId() {
		return discomId;
	}

	public void setDiscomId(Integer discomId) {
		this.discomId = discomId;
	}

	public double getSancLoad() {
		return sancLoad;
	}

	public void setSancLoad(double sancLoad) {
		this.sancLoad = sancLoad;
	}

	public Integer getSolrPvSystemTypeId() {
		return solrPvSystemTypeId;
	}

	public void setSolrPvSystemTypeId(Integer solrPvSystemTypeId) {
		this.solrPvSystemTypeId = solrPvSystemTypeId;
	}

	public Integer getSolrPanelOemId() {
		return solrPanelOemId;
	}

	public void setSolrPanelOemId(Integer solrPanelOemId) {
		this.solrPanelOemId = solrPanelOemId;
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

	public Integer getInverterOemId() {
		return inverterOemId;
	}

	public void setInverterOemId(Integer inverterOemId) {
		this.inverterOemId = inverterOemId;
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

	public DocumentTypes getDocType() {
		return docType;
	}
	
	
}
