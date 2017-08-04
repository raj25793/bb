package org.test.falcon.service;

import java.util.Date;
import java.util.List;

import org.test.falcon.mongo.document.MasterDeviceFeed;

public interface FeedService {

    List<MasterDeviceFeed> getFeeds(Date startTime, Date endTime, String masterDeviceId);

    boolean insertFeeds(List<MasterDeviceFeed> feeds);

}
