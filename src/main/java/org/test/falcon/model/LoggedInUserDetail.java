package org.test.falcon.model;

import java.io.Serializable;

import org.test.falcon.mongo.document.User;

public class LoggedInUserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private User              user;

    private String            jsessionid;

    public LoggedInUserDetail(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJsessionid() {
        return jsessionid;
    }
}
