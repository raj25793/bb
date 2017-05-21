package org.test.falcon.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.falcon.constant.ResponseCodes;
import org.test.falcon.constant.ResponseErrorMessages;
import org.test.falcon.exception.ProAPIException;
import org.test.falcon.model.LoggedInUserDetail;
import org.test.falcon.mongo.document.User;
import org.test.falcon.service.UserService;
import org.test.falcon.util.RequestHolderUtil;

@Aspect
@Component
public class LoginInterceptor {

    @Autowired
    private UserService                                             userService;

    private static Logger                                           LOGGER                =
            LoggerFactory.getLogger(LoginInterceptor.class);
    private static final InheritableThreadLocal<LoggedInUserDetail> activeUserThreadLocal =
            new InheritableThreadLocal<LoggedInUserDetail>();

    private LoggedInUserDetail populateLoggedInUserDetail() {
        try {
            String jSessionId = RequestHolderUtil.getJsessionIdFromRequestCookie();
            User user = userService.findUserById(jSessionId);
            LoggedInUserDetail loggedInUserDetail = new LoggedInUserDetail(jSessionId);
            loggedInUserDetail.setUser(user);
            return loggedInUserDetail;
        }
        catch (Exception e) {
            LOGGER.error("Exception populating LoggedInUserDetail", e);
            throw new ProAPIException(ResponseCodes.UNAUTHORIZED, ResponseErrorMessages.User.UNAUTHORIZED);
        }
    }

    @Before(value = "@within(org.test.falcon.annotation.LoggedIn) || @annotation(org.test.falcon.annotation.LoggedIn)")
    public void userLoggedInBasedonRolesValidation(JoinPoint joinPoint) {
        activeUserThreadLocal.set(null);
        LoggedInUserDetail loggedInUserDetail = populateLoggedInUserDetail();
        if (loggedInUserDetail.getUser() == null) {
            throw new ProAPIException(ResponseCodes.UNAUTHORIZED, ResponseErrorMessages.User.UNAUTHORIZED);
        }
        activeUserThreadLocal.set(loggedInUserDetail);
    }

}
