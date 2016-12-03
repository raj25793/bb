package org.test.falcon.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.falcon.mongo.dao.FeedDao;
import org.test.falcon.mongo.document.MasterDevice;
import org.test.falcon.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private FeedDao feedDao;

    @Override
    public List<MasterDevice> getFeeds(Date startTime, Date endTime) {
        List<MasterDevice> feeds = feedDao.findByCreatedAtBetween(startTime, endTime);
        return feeds;
    }

    @Override
    public List<MasterDevice> insertFeeds(List<MasterDevice> feeds) {
        return feedDao.insert(feeds);
    }

}
