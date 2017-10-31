package org.test.falcon.dw.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.test.falcon.constant.Constant;
import org.test.falcon.dw.dto.TrendDto;
import org.test.falcon.dw.service.TrendService;
import org.test.falcon.mongo.Enum.PowerType;
import org.test.falcon.mongo.Enum.RangeType;
import org.test.falcon.mongo.document.MasterDeviceFeed;

@Service
public class TrendServiceImpl implements TrendService {

    private static final SimpleDateFormat REDSHIFT_DATE_FORMATTER = new SimpleDateFormat("yyyyMMddHHmm");

    @Autowired
    private MongoTemplate                 mongoTemplate;

    @Override
    public List<TrendDto> getDataPoints(
            String fromTime,
            String toTime,
            String deviceId,
            RangeType rangeType,
            PowerType powerType) throws ParseException {
        Date from = REDSHIFT_DATE_FORMATTER.parse(fromTime);
        Date to = REDSHIFT_DATE_FORMATTER.parse(toTime);
        long diff = to.getTime() - from.getTime();
        long daysDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        List<TrendDto> data = getData(rangeType, powerType, daysDiff, from, to, deviceId);
        return data;
    }

    private List<TrendDto> getData(
            RangeType rangeType,
            PowerType powerType,
            long daysDiff,
            Date from,
            Date to,
            String deviceId) {
        List<TrendDto> data = new ArrayList<>();
        if (RangeType.MINUTE.equals(rangeType)) {
            getMinuteWiseData(powerType, data, daysDiff);
        }
        else if (RangeType.HOUR.equals(rangeType)) {
            getHourWiseData(data, from, to, deviceId);
        }
        else if (RangeType.DAY.equals(rangeType)) {
            getDayWiseData(powerType, data, daysDiff);
        }
        else if (RangeType.MONTH.equals(rangeType)) {
            getMonthWiseData(powerType, data);
        }
        else if (RangeType.YEAR.equals(rangeType)) {
            getYearWiseData(powerType, data);
        }
        return data;
    }

    private void getYearWiseData(PowerType powerType, List<TrendDto> data) {

        if (powerType != null) {
            TrendDto dto = new TrendDto();
            double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
            dto.setConsumedPower(randomNum);
            double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
            dto.setGenPower(randomNumGen);
            dto.setYear(2017);
            data.add(dto);

        }
        else {
            if (PowerType.GENERATION.equals(powerType)) {
                TrendDto dto = new TrendDto();
                double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                dto.setGenPower(randomNumGen);
                dto.setYear(2017);
                data.add(dto);
            }
            else {
                TrendDto dto = new TrendDto();
                double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                dto.setConsumedPower(randomNum);
                dto.setYear(2017);
                data.add(dto);
            }
        }

    }

    private void getMonthWiseData(PowerType powerType, List<TrendDto> data) {

        if (powerType != null) {
            TrendDto dto = new TrendDto();
            double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
            dto.setConsumedPower(randomNum);
            double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
            dto.setGenPower(randomNumGen);
            dto.setYear(2017);
            dto.setMonth(03);
            data.add(dto);

        }
        else {
            if (PowerType.GENERATION.equals(powerType)) {
                TrendDto dto = new TrendDto();
                double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                dto.setGenPower(randomNumGen);
                dto.setYear(2017);
                dto.setMonth(03);
                data.add(dto);
            }
            else {
                TrendDto dto = new TrendDto();
                double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                dto.setConsumedPower(randomNum);
                dto.setYear(2017);
                dto.setMonth(03);
                data.add(dto);
            }
        }

    }

    private void getDayWiseData(PowerType powerType, List<TrendDto> data, long daysDiff) {

        if (powerType != null) {
            for (int i = 0; i < daysDiff; i++) {
                TrendDto dto = new TrendDto();
                double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                dto.setConsumedPower(randomNum);
                double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                dto.setGenPower(randomNumGen);
                dto.setYear(2017);
                dto.setMonth(03);
                dto.setDay(i);
                data.add(dto);
            }
        }
        else {
            if (PowerType.GENERATION.equals(powerType)) {
                for (int i = 0; i < daysDiff; i++) {
                    TrendDto dto = new TrendDto();
                    double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                    dto.setGenPower(randomNumGen);
                    dto.setYear(2017);
                    dto.setMonth(03);
                    dto.setDay(i);
                    data.add(dto);
                }
            }
            else {
                for (int i = 0; i < daysDiff; i++) {
                    TrendDto dto = new TrendDto();
                    double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                    dto.setConsumedPower(randomNum);
                    dto.setYear(2017);
                    dto.setMonth(03);
                    dto.setDay(i);
                    data.add(dto);
                }
            }
        }

    }

    // private void getHourWiseData(PowerType powerType, List<TrendDto> data,
    // long daysDiff) {
    // if (powerType != null) {
    // for (int i = 0; i < daysDiff; i++) {
    // for (int j = 0; j < 24; j++) {
    // TrendDto dto = new TrendDto();
    // double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
    // dto.setConsumedPower(randomNum);
    // double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
    // dto.setGenPower(randomNumGen);
    // dto.setYear(2017);
    // dto.setMonth(03);
    // dto.setDay(i);
    // dto.setHour(j);
    // data.add(dto);
    //
    // }
    // }
    // }
    // else {
    // if (PowerType.GENERATION.equals(powerType)) {
    // for (int i = 0; i < daysDiff; i++) {
    // for (int j = 0; j < 24; j++) {
    // TrendDto dto = new TrendDto();
    // double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
    // dto.setGenPower(randomNumGen);
    // dto.setYear(2017);
    // dto.setMonth(03);
    // dto.setDay(i);
    // dto.setHour(j);
    // data.add(dto);
    //
    // }
    // }
    // }
    // else {
    // for (int i = 0; i < daysDiff; i++) {
    // for (int j = 0; j < 24; j++) {
    // TrendDto dto = new TrendDto();
    // double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
    // dto.setConsumedPower(randomNum);
    // dto.setYear(2017);
    // dto.setMonth(03);
    // dto.setDay(i);
    // dto.setHour(j);
    // data.add(dto);
    //
    // }
    // }
    // }
    // }
    // }

    private void getHourWiseData(List<TrendDto> data, Date from, Date to, String deviceId) {
        Date fromDate = getStartOfHour(from);
        Date toDate = DateUtils.addHours(fromDate, 1);

        while (to.after(toDate)) {
            Query query = new Query(
                    Criteria.where(Constant.CREATED_AT).gte(fromDate).and(Constant.MASTER_DEVICE_ID).is(deviceId));
            query.with(new Sort(Direction.ASC, Constant.CREATED_AT)).limit(1);
            List<MasterDeviceFeed> startFeeds = mongoTemplate.find(query, MasterDeviceFeed.class);
            TrendDto dto = new TrendDto();
            dto.setTo(toDate);
            dto.setFrom(fromDate);

            if (CollectionUtils.isNotEmpty(startFeeds)) {
                MasterDeviceFeed startFeed = startFeeds.get(0);
                Query query2 = new Query(
                        Criteria.where(Constant.CREATED_AT).lte(toDate).and(Constant.MASTER_DEVICE_ID).is(deviceId));
                query2.with(new Sort(Direction.DESC, Constant.CREATED_AT)).limit(1);
                MasterDeviceFeed endFeed = mongoTemplate.find(query2, MasterDeviceFeed.class).get(0);
                if (endFeed != null && startFeed != null) {
                    if (endFeed.getChildDevices().get(0).getReadings().get("energy") != null
                            && startFeed.getChildDevices().get(0).getReadings().get("energy") != null) {
                        dto.setConsumedPower(
                                Double.valueOf(
                                        endFeed.getChildDevices().get(0).getReadings().get("energy")
                                                - startFeed.getChildDevices().get(0).getReadings().get("energy")));
                    }
                }
            }

            data.add(dto);

            fromDate = toDate;
            toDate = DateUtils.addHours(toDate, 1);
        }

        if (toDate.after(to)) {
            Query query = new Query(
                    Criteria.where(Constant.CREATED_AT).gte(fromDate).and(Constant.MASTER_DEVICE_ID).is(deviceId));
            query.with(new Sort(Direction.ASC, Constant.CREATED_AT)).limit(1);
            TrendDto dto = new TrendDto();
            dto.setTo(toDate);
            dto.setFrom(fromDate);
            List<MasterDeviceFeed> startFeeds = mongoTemplate.find(query, MasterDeviceFeed.class);

            if (CollectionUtils.isNotEmpty(startFeeds)) {
                MasterDeviceFeed startFeed = startFeeds.get(0);
                Query query2 = new Query(
                        Criteria.where(Constant.CREATED_AT).lte(to).and(Constant.MASTER_DEVICE_ID).is(deviceId));
                query2.with(new Sort(Direction.DESC, Constant.CREATED_AT)).limit(1);
                MasterDeviceFeed endFeed = mongoTemplate.find(query2, MasterDeviceFeed.class).get(0);

                if (endFeed != null && startFeed != null) {
                    if (endFeed.getChildDevices().get(0).getReadings().get("energy") != null
                            && startFeed.getChildDevices().get(0).getReadings().get("energy") != null) {
                        dto.setConsumedPower(
                                Double.valueOf(
                                        endFeed.getChildDevices().get(0).getReadings().get("energy")
                                                - startFeed.getChildDevices().get(0).getReadings().get("energy")));
                    }
                }

            }

            data.add(dto);
        }

    }

    private Date getStartOfHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();
        return date;
    }

    private void getMinuteWiseData(PowerType powerType, List<TrendDto> data, long daysDiff) {
        if (powerType != null) {
            for (int i = 0; i < daysDiff; i++) {
                for (int j = 0; j < 24; j++) {
                    for (int k = 0; k < 60; k++) {
                        TrendDto dto = new TrendDto();
                        double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                        dto.setConsumedPower(randomNum);
                        double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                        dto.setGenPower(randomNumGen);
                        dto.setYear(2017);
                        dto.setMonth(03);
                        dto.setDay(i);
                        dto.setHour(j);
                        dto.setMinute(k);
                        data.add(dto);
                    }

                }
            }
        }
        else {
            if (PowerType.GENERATION.equals(powerType)) {
                for (int i = 0; i < daysDiff; i++) {
                    for (int j = 0; j < 24; j++) {
                        for (int k = 0; k < 60; k++) {
                            TrendDto dto = new TrendDto();
                            double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                            dto.setGenPower(randomNumGen);
                            dto.setYear(2017);
                            dto.setMonth(03);
                            dto.setDay(i);
                            dto.setHour(j);
                            dto.setMinute(k);
                            data.add(dto);
                        }

                    }
                }
            }
            else {
                for (int i = 0; i < daysDiff; i++) {
                    for (int j = 0; j < 24; j++) {
                        for (int k = 0; k < 60; k++) {
                            TrendDto dto = new TrendDto();
                            double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                            dto.setConsumedPower(randomNum);
                            dto.setYear(2017);
                            dto.setMonth(03);
                            dto.setDay(i);
                            dto.setHour(j);
                            dto.setMinute(k);
                            data.add(dto);
                        }

                    }
                }
            }
        }
    }

}
