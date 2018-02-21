package org.test.falcon.contract.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contracts")
public class Contract implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    @Column(name = "project_id")
    private Integer           projectId;

    @Column(name = "builder_acc_id")
    private String            builderAcc;

    @Column(name = "broker_acc_id")
    private String            brokerAcc;

    @Column(name = "commission_to_broker")
    private Double            commissionToBroker;

    @Column(name = "commission_to_buyer")
    private Double            commissionToBuyer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getBuilderAcc() {
        return builderAcc;
    }

    public void setBuilderAcc(String builderAcc) {
        this.builderAcc = builderAcc;
    }

    public String getBrokerAcc() {
        return brokerAcc;
    }

    public void setBrokerAcc(String brokerAcc) {
        this.brokerAcc = brokerAcc;
    }

    public Double getCommissionToBroker() {
        return commissionToBroker;
    }

    public void setCommissionToBroker(Double commissionToBroker) {
        this.commissionToBroker = commissionToBroker;
    }

    public Double getCommissionToBuyer() {
        return commissionToBuyer;
    }

    public void setCommissionToBuyer(Double commissionToBuyer) {
        this.commissionToBuyer = commissionToBuyer;
    }

}
