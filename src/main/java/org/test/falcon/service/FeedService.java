package org.test.falcon.service;

import java.util.Date;
import java.util.List;

import org.test.falcon.mongo.document.Feed;

public interface FeedService {

    List<Feed> getFeeds(Date startTime, Date endTime);

    List<Feed> insertFeeds(List<Feed> feeds);

}
