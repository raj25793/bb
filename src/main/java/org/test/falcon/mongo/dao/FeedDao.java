package org.test.falcon.mongo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.test.falcon.mongo.document.MasterDevice;

public interface FeedDao extends MongoRepository<MasterDevice, String> {

    @Query(value = "{'createdAt' : { '$gt' : ?0 , '$lte' : ?1}}")
    List<MasterDevice> findByCreatedAtBetween(Date startTime, Date endTime);

}
