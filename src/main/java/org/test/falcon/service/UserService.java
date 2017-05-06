package org.test.falcon.service;

import org.test.falcon.dto.UserDto;
import org.test.falcon.mongo.document.User;

public interface UserService {
	
	UserDto getUserInfo(String userId);
	
	User createOrPatchUser(User user);

}
