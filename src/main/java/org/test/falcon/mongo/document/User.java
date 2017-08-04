package org.test.falcon.mongo.document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.test.falcon.enums.DocumentTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
@Document(collection = "user")
public class User extends UserLogin implements Serializable {

    /**
     *
     */
    private static final long   serialVersionUID = 1L;

    @Field(value = "doc_type")
    private final DocumentTypes docType          = DocumentTypes.USER;

    @Field(value = "email")
    private String              email;

    @Field(value = "verified")
    private boolean             isVerified;

    @Field(value = "address")
    private String              address;

    @Field(value = "phone")
    private String              phone;

    @Field(value = "leads")
    @ApiModelProperty(hidden = true)
    private List<Lead>          leads;

    @Field(value = "updated_at")
    private Date                updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DocumentTypes getDocType() {
        return docType;
    }

}
