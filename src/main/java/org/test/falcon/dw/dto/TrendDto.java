package org.test.falcon.dw.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class TrendDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Double            genPower;

    private Double            consumedPower;

    private Date              from;

    private Date              to;

    private Integer           minute;

    private Integer           hour;

    private Integer           day;

    private Integer           month;

    private Integer           year;

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Double getGenPower() {
        return genPower;
    }

    public void setGenPower(Double genPower) {
        this.genPower = genPower;
    }

    public Double getConsumedPower() {
        return consumedPower;
    }

    public void setConsumedPower(Double consumedPower) {
        this.consumedPower = consumedPower;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
