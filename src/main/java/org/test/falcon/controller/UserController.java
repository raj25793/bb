package org.test.falcon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.constant.ResponseCodes;
import org.test.falcon.constant.ResponseErrorMessages;
import org.test.falcon.dto.RegisterUser;
import org.test.falcon.dto.User;
import org.test.falcon.exception.UnauthorizedException;
import org.test.falcon.model.LoginObject;
import org.test.falcon.pojo.response.GenericApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Controller
@Api(value = "User Api")
public class UserController {

	// 1. api for login
	// 2. api for fetching user details

    @ApiOperation(value = "login api")
	@RequestMapping(value = "/v1/login", method = RequestMethod.POST)
	@ResponseBody
	public GenericApiResponse login(@RequestBody LoginObject loginObject) {
		User user = new User();
		if (user.getUserName().equalsIgnoreCase(loginObject.getUserName())) {
			if (user.getPassword().equals(loginObject.getPassword())) {
				return new GenericApiResponse(user);
			}
		}
		throw new UnauthorizedException(ResponseCodes.UNAUTHORIZED, ResponseErrorMessages.User.UNAUTHORIZED);

	}

    @ApiOperation(value = "sign up api")
    @RequestMapping(value = "app/v1/register", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse registerUser(@RequestBody RegisterUser user) {
        return null;

    }

	// @ApiOperation(value = "user details api")
	// @RequestMapping(value = "/v1/user-details", method = RequestMethod.GET)
	// @ResponseBody
	// public GenericApiResponse getFeed(
	// @RequestParam(value = "startTime", required = true) long startTime,
	// @RequestParam(value = "endTime", required = true) long endTime) {
	// List<MasterDevice> feeds = feedService.getFeeds(new Date(startTime), new
	// Date(endTime));
	// return new GenericApiResponse(feeds);
	// }

}
