package org.test.falcon.service.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.test.falcon.constant.Constant;
import org.test.falcon.mongo.document.MasterDevice;
import org.test.falcon.service.FeedService;
import org.test.falcon.util.CommonUtil;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MasterDevice> getFeeds(Date startTime, Date endTime) {
        ObjectId fromTime = CommonUtil.getObjectIdByTime(startTime);
        ObjectId toTime = CommonUtil.getObjectIdByTime(endTime);
        Query query = new Query(Criteria.where(Constant.ID).gte(fromTime).lte(toTime));
        List<MasterDevice> feeds = mongoTemplate.find(query, MasterDevice.class);
        return feeds;
    }

    @Override
    public boolean insertFeeds(List<MasterDevice> feeds) {
        boolean success = true;
        try {
            mongoTemplate.insert(feeds, MasterDevice.class);
        }
        catch (Exception e) {
            success = false;
        }
        return success;
    }

}
