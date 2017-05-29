package org.test.falcon.dw.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.test.falcon.dw.dto.TrendDto;
import org.test.falcon.dw.service.TrendService;
import org.test.falcon.mongo.Enum.PowerType;
import org.test.falcon.mongo.Enum.RangeType;

@Service
public class TrendServiceImpl implements TrendService {

    private static final SimpleDateFormat REDSHIFT_DATE_FORMATTER = new SimpleDateFormat("yyyyMMddHHmm");

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
        List<TrendDto> data = getData(rangeType, powerType, daysDiff);
        return data;
    }

    private List<TrendDto> getData(RangeType rangeType, PowerType powerType, long daysDiff) {
        List<TrendDto> data = new ArrayList<>();
        if (RangeType.MINUTE.equals(rangeType)) {
            getMinuteWiseData(powerType, data, daysDiff);
        }
        else if (RangeType.HOUR.equals(rangeType)) {
            getHourWiseData(powerType, data, daysDiff);
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

    private void getHourWiseData(PowerType powerType, List<TrendDto> data, long daysDiff) {
        if (powerType != null) {
            for (int i = 0; i < daysDiff; i++) {
                for (int j = 0; j < 24; j++) {
                    TrendDto dto = new TrendDto();
                    double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                    dto.setConsumedPower(randomNum);
                    double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                    dto.setGenPower(randomNumGen);
                    dto.setYear(2017);
                    dto.setMonth(03);
                    dto.setDay(i);
                    dto.setHour(j);
                    data.add(dto);

                }
            }
        }
        else {
            if (PowerType.GENERATION.equals(powerType)) {
                for (int i = 0; i < daysDiff; i++) {
                    for (int j = 0; j < 24; j++) {
                        TrendDto dto = new TrendDto();
                        double randomNumGen = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                        dto.setGenPower(randomNumGen);
                        dto.setYear(2017);
                        dto.setMonth(03);
                        dto.setDay(i);
                        dto.setHour(j);
                        data.add(dto);

                    }
                }
            }
            else {
                for (int i = 0; i < daysDiff; i++) {
                    for (int j = 0; j < 24; j++) {
                        TrendDto dto = new TrendDto();
                        double randomNum = ThreadLocalRandom.current().nextInt(200, 240 + 1);
                        dto.setConsumedPower(randomNum);
                        dto.setYear(2017);
                        dto.setMonth(03);
                        dto.setDay(i);
                        dto.setHour(j);
                        data.add(dto);

                    }
                }
            }
        }
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
