package org.test.falcon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.mongo.document.Feed;
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
    public List<Feed> getFeed(
            @RequestParam(value = "startTime", required = true) long startTime,
            @RequestParam(value = "endTime", required = true) long endTime) {
        return feedService.getFeeds(new Date(startTime), new Date(endTime));
    }

    @ApiOperation(value = "Post feeds")
    @RequestMapping(value = "/v1/feed", method = RequestMethod.POST)
    @ResponseBody
    public boolean postFeeds(@RequestBody List<Feed> feeds) {
        List<Feed> savedFeeds = feedService.insertFeeds(feeds);
        if (savedFeeds != null && !savedFeeds.isEmpty()) {
            return true;
        }
        return false;
    }

}
