package org.test.falcon.mongo.document;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@Document(collection = "feed")
public class MasterDevice implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String            id;

    @Field(value = "master_id")
    private String            uniqueDeviceId;

    @Field(value = "readings")
    private List<ChildDevice> childDevices;

    public List<ChildDevice> getChildDevices() {
        return childDevices;
    }

    public void setChildDevices(List<ChildDevice> childDevices) {
        this.childDevices = childDevices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniqueDeviceId() {
        return uniqueDeviceId;
    }

    public void setUniqueDeviceId(String uniqueDeviceId) {
        this.uniqueDeviceId = uniqueDeviceId;
    }

}
