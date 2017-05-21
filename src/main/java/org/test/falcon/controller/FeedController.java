package org.test.falcon.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.mongo.document.MasterDevice;
import org.test.falcon.pojo.response.GenericApiResponse;
import org.test.falcon.service.FeedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "Feeds api")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @ApiOperation(value = "Get feeds")
    @RequestMapping(value = "/v1/feed", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getFeed(
            @RequestParam(value = "startTime", required = true) long startTime,
            @RequestParam(value = "endTime", required = true) long endTime,
            @RequestParam(value = "deviceId", required = true) String deviceId) {
        List<MasterDevice> feeds = feedService.getFeeds(new Date(startTime), new Date(endTime));
        return new GenericApiResponse(feeds);
    }

    @ApiOperation(value = "Post feeds")
    @RequestMapping(value = "/v1/feeds", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse postFeeds(@RequestBody List<MasterDevice> feeds) {
        boolean success = feedService.insertFeeds(feeds);
        return new GenericApiResponse(success);
    }

    @ApiOperation(value = "Post feed")
    @RequestMapping(value = "/v1/feed", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse postFeed(@RequestBody MasterDevice feed) {
        boolean success = feedService.insertFeeds(Arrays.asList(feed));
        return new GenericApiResponse(success);
    }

}
