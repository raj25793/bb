package org.test.falcon.service;

import java.util.Date;
import java.util.List;

import org.test.falcon.mongo.document.MasterDevice;

public interface FeedService {

    List<MasterDevice> getFeeds(Date startTime, Date endTime);

    boolean insertFeeds(List<MasterDevice> feeds);

}
