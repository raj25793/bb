package org.test.falcon.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.constant.Constant;
import org.test.falcon.constant.ResponseCodes;
import org.test.falcon.constant.ResponseErrorMessages;
import org.test.falcon.mongo.document.User;
import org.test.falcon.pojo.response.GenericApiResponse;
import org.test.falcon.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "Login Api")
public class LoginController {

    // 1. api for login
    // 2. api for fetching user details

    @Autowired
    private UserService userService;

    @ApiOperation(value = "sign up api")
    @RequestMapping(value = "app/v1/login", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse userLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password) {
        User user = userService.login(userName, password);
        if (user == null) {
            return new GenericApiResponse(
                    ResponseErrorMessages.User.USER_NAME_PASSWORD_INCORRECT,
                    ResponseCodes.INVALID_USERNAME);
        }
        if (!password.equals(user.getPassword())) {
            return new GenericApiResponse(ResponseErrorMessages.User.BAD_CREDENTIAL, ResponseCodes.BAD_CREDENTIAL);
        }
        Cookie loginCookie = new Cookie(Constant.JSESSIONID, user.getId());
        // setting cookie to expiry in 30 mins
        loginCookie.setMaxAge(30 * 60);
        response.addCookie(loginCookie);
        return new GenericApiResponse(user);

    }

    @ApiOperation(value = "api for creating user", notes = "This api creaates user data in mongo")
    @RequestMapping(value = "app/v1/register", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse registerUser(@RequestBody User user) {
        return new GenericApiResponse(userService.createOrPatchUser(user));
    }

}
