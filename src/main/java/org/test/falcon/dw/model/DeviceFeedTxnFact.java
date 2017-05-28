package org.test.falcon.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.test.falcon.mongo.Enum.PowerType;

@Entity
@Table(name = "device_feed_txn_fact")
public class DeviceFeedTxnFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private String        deviceId;

    @Column(name = "time_key")
    private Long          timeKey;

    @OneToOne
    @JoinColumn(name = "time_key", nullable = false, updatable = false, insertable = false)
    private TimeDimension timeDimension;

    @Column(name = "power_type")
    private PowerType     powerType;

    @Column(name = "avg_voltage")
    private Double        avgVoltage;

    @Column(name = "avg_current")
    private Double        avgCurrent;

    @Column(name = "avg_power")
    private Double        avgPower;

    @Column(name = "energy")
    private Double        energy;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public TimeDimension getTimeDimension() {
        return timeDimension;
    }

    public void setTimeDimension(TimeDimension timeDimension) {
        this.timeDimension = timeDimension;
    }

    public Long getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(Long timeKey) {
        this.timeKey = timeKey;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public Double getAvgVoltage() {
        return avgVoltage;
    }

    public void setAvgVoltage(Double avgVoltage) {
        this.avgVoltage = avgVoltage;
    }

    public Double getAvgCurrent() {
        return avgCurrent;
    }

    public void setAvgCurrent(Double avgCurrent) {
        this.avgCurrent = avgCurrent;
    }

    public Double getAvgPower() {
        return avgPower;
    }

    public void setAvgPower(Double avgPower) {
        this.avgPower = avgPower;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

}
