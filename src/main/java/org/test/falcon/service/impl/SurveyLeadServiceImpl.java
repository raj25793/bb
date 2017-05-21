package org.test.falcon.service.impl;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.test.falcon.constant.Constant;
import org.test.falcon.exception.ProAPIException;
import org.test.falcon.mongo.document.Lead;
import org.test.falcon.mongo.document.User;
import org.test.falcon.service.SurveyLeadService;
import org.test.falcon.service.UserService;

@Service
public class SurveyLeadServiceImpl implements SurveyLeadService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserService   userService;

    @Override
    public Lead insertLead(Lead surveyLead) {

        User user = null;
        if (surveyLead.getPhone().isEmpty() || surveyLead.getPhone() == null) {
            throw new ProAPIException("Phone no. is required.");
        }
        user = userService.findUserByPhone(surveyLead.getPhone());
        if (user != null) {
            Update update = new Update();
            update.push(Constant.SURVEY_LEADS, surveyLead);
            update.set(Constant.UPDATED_AT, new Date());
            mongoTemplate.updateFirst(new Query(Criteria.where(Constant.ID).is(user.getId())), update, User.class);
        }
        else {
            user = new User();
            if (surveyLead != null && surveyLead.getName() != null || !surveyLead.getName().isEmpty()) {
                user.setUsername(surveyLead.getName());
            }
            else if (surveyLead != null && surveyLead.getEmailId() != null || !surveyLead.getEmailId().isEmpty()) {
                user.setUsername(surveyLead.getEmailId());
                user.setEmail(surveyLead.getEmailId());
            }
            else {
                user.setUsername(surveyLead.getPhone());
            }
            user.setAddress(surveyLead.getAddress());
            user.setPhone(surveyLead.getPhone());
            user.setPassword("abc123");
            user.setLeads(Arrays.asList(surveyLead));
            mongoTemplate.insert(Arrays.asList(user), User.class);
            // XXX trigger sms and email to user for username and password

        }

        return surveyLead;
    }

}
