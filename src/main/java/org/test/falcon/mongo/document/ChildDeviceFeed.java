package org.test.falcon.mongo.document;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ChildDeviceFeed implements Serializable {

    /**
     *
     */
    private static final long  serialVersionUID = 1L;

    @Field(value = "child_id")
    private String             uniqId;

    @Field(value = "readings")
    private Map<String, Float> readings;

    @Field(value = "created_at")
    private Date               createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public Map<String, Float> getReadings() {
        return readings;
    }

    public void setReadings(Map<String, Float> readings) {
        this.readings = readings;
    }
}
