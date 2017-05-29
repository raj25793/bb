package org.test.falcon.dw.service;

import java.text.ParseException;
import java.util.List;

import org.test.falcon.dw.dto.TrendDto;
import org.test.falcon.mongo.Enum.PowerType;
import org.test.falcon.mongo.Enum.RangeType;

public interface TrendService {

    List<TrendDto> getDataPoints(
            String fromTime,
            String toTime,
            String deviceId,
            RangeType rangeType,
            PowerType powerType) throws ParseException;

}
