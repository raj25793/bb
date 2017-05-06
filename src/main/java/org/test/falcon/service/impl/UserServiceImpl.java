package org.test.falcon.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.test.falcon.constant.Constant;
import org.test.falcon.dto.LeadDto;
import org.test.falcon.dto.UserDto;
import org.test.falcon.mongo.document.Lead;
import org.test.falcon.mongo.document.User;
import org.test.falcon.service.UserService;
import org.test.falcon.util.CommonUtil;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public UserDto getUserInfo(String userId) {
		Query query = new Query(Criteria.where(Constant.ID).is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		UserDto userDto = populateUerDto(user);
		return userDto;
	}

	private UserDto populateUerDto(User user) {
		UserDto dto = new UserDto();
		CommonUtil.copyDtoProperties(dto, user);
//		setCategory();
//		setDiscom();
//		setSolrPanelOem();
//		setInverterOem();
		List<LeadDto> leadDtos = new ArrayList<>();
		for(Lead l :user.getLeads()) {
			LeadDto leadDto = new LeadDto();
			CommonUtil.copyDtoProperties(leadDto, l);
//			setCountry();
//			setCity();
//			setState();
			leadDtos.add(leadDto);
		}
		dto.setLeadDtos(leadDtos);
		return dto;
	}

	@Override
	public User createOrPatchUser(User user) {
		if(user.getId() != null) {
			Query query = new Query(Criteria.where(Constant.ID).is(user.getId()));
			User savedUser = mongoTemplate.findOne(query, User.class);
			CommonUtil.copyDtoProperties(savedUser, user);
		}
		else {
			mongoTemplate.insert(Arrays.asList(user), User.class);
		}
		return user;
	}

}
