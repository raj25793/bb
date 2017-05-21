package org.test.falcon.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.test.falcon.constant.Constant;
import org.test.falcon.dto.LeadDto;
import org.test.falcon.dto.UserDto;
import org.test.falcon.mongo.document.Lead;
import org.test.falcon.mongo.document.User;
import org.test.falcon.service.UserService;
import org.test.falcon.util.CommonUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserDto getUserInfo(String userId) {
        Query query = new Query(Criteria.where(Constant.ID).is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        UserDto userDto = populateUserDto(user);
        return userDto;
    }

    @Override
    public User findUserById(String userId) {
        Query query = new Query(Criteria.where(Constant.ID).is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    private UserDto populateUserDto(User user) {
        UserDto dto = new UserDto();
        CommonUtil.copyDtoProperties(dto, user);
        // setCategory();
        // setDiscom();
        // setSolrPanelOem();
        // setInverterOem();
        List<LeadDto> leadDtos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(user.getLeads())) {
            for (Lead l : user.getLeads()) {
                LeadDto leadDto = new LeadDto();
                CommonUtil.copyDtoProperties(leadDto, l);
                // setCountry();
                // setCity();
                // setState();
                leadDtos.add(leadDto);
            }
        }
        dto.setLeadDtos(leadDtos);
        return dto;
    }

    @Override
    public User createOrPatchUser(User user) {
        if (user.getId() != null) {
            Query query = new Query(Criteria.where(Constant.ID).is(user.getId()));
            User savedUser = mongoTemplate.findOne(query, User.class);
            CommonUtil.copyDtoProperties(savedUser, user);
        }
        else {
            mongoTemplate.insert(Arrays.asList(user), User.class);
        }
        return user;
    }

    @Override
    public User login(String userName, String password) {
        Query query = new Query(Criteria.where(Constant.USER_NAME).is(userName));
        User savedUser = mongoTemplate.findOne(query, User.class);
        return savedUser;
    }

    @Override
    public User findUserByPhone(String phone) {
        Query query = new Query(Criteria.where(Constant.PHONE).is(phone));
        return mongoTemplate.findOne(query, User.class);
    }

}
