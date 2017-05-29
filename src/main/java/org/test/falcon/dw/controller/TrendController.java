package org.test.falcon.dw.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.dw.dto.TrendDto;
import org.test.falcon.dw.service.TrendService;
import org.test.falcon.mongo.Enum.PowerType;
import org.test.falcon.mongo.Enum.RangeType;
import org.test.falcon.pojo.response.GenericApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api
@RequestMapping(value = "/v1")
// @LoggedIn
public class TrendController {

    @Autowired
    private TrendService trendService;

    @ApiOperation(value = "api for fetching data to show in trends")
    @RequestMapping(value = "trend", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getTrend(
            @ApiParam(
                    value = "Date value in yyyyMMddHHmm format like 201604010000 for 1st apr 2016 00:00") @RequestParam(
                            required = true) String fromTime,
            @ApiParam(
                    value = "Date value in yyyyMMddHHmm format like 201604010000 for 1st apr 2016 00:00") @RequestParam(
                            required = true) String toTime,
            @ApiParam @RequestParam(required = true) String deviceId,
            @ApiParam @RequestParam(required = true) RangeType rangeType,
            @ApiParam @RequestParam(required = false) PowerType powerType) throws ParseException {
        List<TrendDto> trendData = trendService.getDataPoints(fromTime, toTime, deviceId, rangeType, powerType);
        return new GenericApiResponse(trendData);
    }

}
