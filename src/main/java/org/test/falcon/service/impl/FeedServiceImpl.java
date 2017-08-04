package org.test.falcon.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.test.falcon.constant.Constant;
import org.test.falcon.mongo.document.MasterDeviceFeed;
import org.test.falcon.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MasterDeviceFeed> getFeeds(Date startTime, Date endTime, String masterDeviceId) {
        // ObjectId fromTime = CommonUtil.getObjectIdByTime(startTime);
        // ObjectId toTime = CommonUtil.getObjectIdByTime(endTime);
        Query query = new Query(
                Criteria.where(Constant.CREATED_AT).gte(startTime).lte(endTime).and(Constant.MASTER_DEVICE_ID)
                        .is(masterDeviceId));
        List<MasterDeviceFeed> feeds = mongoTemplate.find(query, MasterDeviceFeed.class);
        return feeds;
    }

    @Override
    public boolean insertFeeds(List<MasterDeviceFeed> feeds) {
        boolean success = true;
        try {
            mongoTemplate.insert(feeds, MasterDeviceFeed.class);
        }
        catch (Exception e) {
            success = false;
        }
        return success;
    }

}
