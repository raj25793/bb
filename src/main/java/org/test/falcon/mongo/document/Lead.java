package org.test.falcon.mongo.document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@Document(collection = "user")
public class Lead implements Serializable {

    /**
     * 
     */
    private static final long           serialVersionUID = 1L;

    @Id
    private String                      id;

    @Field(value = "name")
    private String                      name;

    @Field(value = "address")
    private String                      address;

    @Field(value = "landmark")
    private String                      landmark;

    @Field(value = "location")
    private LocationPoint<GeoJsonPoint> locationPoint;

    @Field(value = "city")
    private Integer                     cityId;

    @Field(value = "state")
    private Integer                     stateId;

    @Field(value = "phone")
    private String                      phone;

    @Field(value = "email")
    private String                      emailId;

    @Field(value = "discom")
    private Integer                     discomId;

    @Field(value = "acc_name")
    private String                      accountName;

    @Field(value = "cat_id")
    private Integer                     categoryId;

    @Field(value = "contact_person")
    private String                      contactPerson;

    @Field(value = "sanc_load")
    private Double                      sancLoad;

    @Field(value = "solr_type")
    private Integer                     solrPvSystemTypeId;

    @Field(value = "solr_oem")
    private Integer                     solrPanelOemId;

    @Field(value = "solr_spec")
    private String                      solrPanelSpecification;

    @Field(value = "solr_panels")
    private Integer                     solrPanelQuantity;

    @Field(value = "inverter_oem")
    private Integer                     inverterOemId;

    @Field(value = "inverter_spec")
    private String                      inverterSpecification;

    @Field(value = "inverters")
    private Integer                     inverterQuantity;

    @Field(value = "comm_date")
    private Date                        commissioningDate;
    
    @Field(value = "main_devs")
    private List<MasterDevice> masterDevices;
    
    @Field(value = "individual_devs")
    private List<childDevice> childDevices;

    public List<MasterDevice> getMasterDevices() {
		return masterDevices;
	}

	public void setMasterDevices(List<MasterDevice> masterDevices) {
		this.masterDevices = masterDevices;
	}

	public List<childDevice> getChildDevices() {
		return childDevices;
	}

	public void setChildDevices(List<childDevice> childDevices) {
		this.childDevices = childDevices;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDiscomId() {
        return discomId;
    }

    public void setDiscomId(Integer discomId) {
        this.discomId = discomId;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Double getSancLoad() {
        return sancLoad;
    }

    public void setSancLoad(Double sancLoad) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public LocationPoint<GeoJsonPoint> getLocationPoint() {
        return locationPoint;
    }

    public void setLocationPoint(LocationPoint<GeoJsonPoint> locationPoint) {
        this.locationPoint = locationPoint;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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
