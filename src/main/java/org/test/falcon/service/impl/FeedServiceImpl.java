package org.test.falcon.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.falcon.mongo.dao.FeedDao;
import org.test.falcon.mongo.document.Feed;
import org.test.falcon.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private FeedDao feedDao;

    @Override
    public List<Feed> getFeeds(Date startTime, Date endTime) {
        List<Feed> feeds = feedDao.findByCreatedAtBetween(startTime, endTime);
        return feeds;
    }

    @Override
    public List<Feed> insertFeeds(List<Feed> feeds) {
        return feedDao.insert(feeds);
    }

}
