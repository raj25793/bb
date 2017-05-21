package org.test.falcon.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieHelper {

    private CookieHelper() {
    }

    /**
     * Returns cookie from a request object... picks first cookie by the
     * available name.. returns null if cookie is not available or request if
     * null
     * 
     * @param request
     * @param cookieKey
     * @return
     */
    public static String getCookieFromRequest(HttpServletRequest request, String cookieKey) {
        String cookieValue = null;
        if (request != null && request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieKey)) {
                    cookieValue = cookie.getValue();
                    break;
                }

            }
        }

        return cookieValue;
    }
}
