package org.test.falcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.annotation.LoggedIn;
import org.test.falcon.dto.UserDto;
import org.test.falcon.pojo.response.GenericApiResponse;
import org.test.falcon.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "User Api")
@LoggedIn
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "api for fetching user data", notes = "This api fetches user data from mongo for dashboard")
    @RequestMapping(value = "/v1/user-info/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getUserInfo(@PathVariable String userId) {
        UserDto user = userService.getUserInfo(userId);
        return new GenericApiResponse(user);
    }

}
