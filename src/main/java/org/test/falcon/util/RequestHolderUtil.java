package org.test.falcon.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.test.falcon.constant.Constant;

/**
 * 
 * @author rajatagarwal
 *
 */
public class RequestHolderUtil {
    private static final String HEADER_X_ISHTTPS = "X-ISHTTPS";
    private static Logger       logger           = LoggerFactory.getLogger(RequestHolderUtil.class);

    public static RequestAttributes getRequestAttributes() {
        return RequestContextHolder.getRequestAttributes();
    }

    /**
     * By default it will return true until and unless apache set X-ISHTTPS in
     * request header
     * 
     * @return
     */
    public static boolean isHttpsRequest() {
        RequestAttributes attributes = getRequestAttributes();
        if (attributes != null && attributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
            String isHttps = request.getHeader(HEADER_X_ISHTTPS);
            if (isHttps != null) {
                return isHttps.equalsIgnoreCase("on");
            }
        }
        // by default https, until and unless api get mentioned header set
        return Boolean.TRUE;
    }

    public static String getCookie(String cookieKey) {
        String cookieValue = null;
        RequestAttributes requestAttribute = getRequestAttributes();
        if (requestAttribute != null && requestAttribute instanceof ServletRequestAttributes) {
            cookieValue = CookieHelper
                    .getCookieFromRequest(((ServletRequestAttributes) requestAttribute).getRequest(), cookieKey);
        }
        return cookieValue;
    }

    public static String getJsessionIdFromRequestCookie() {
        return getCookie(Constant.JSESSIONID);
    }

    /**
     * 
     * @return {@link String}
     */
    public static String getUserProvidedHost() {
        String host = null;
        RequestAttributes requestAttributes = getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            host = request.getHeader(Constant.CUSTOM_HOST_HEADER);
        }
        return host;
    }

    public static HttpHeaders getHeaderContainingJsessionId() {
        HttpHeaders headers = new HttpHeaders();
        String jsessionId = getJsessionIdFromRequestCookie();
        logger.debug("COOKIE FOUND: " + jsessionId);
        headers.add("Cookie", Constant.JSESSIONID + "=" + jsessionId);
        return headers;
    }

    public static void logRequestDetails() {
        RequestAttributes requestAttribute = getRequestAttributes();
        StringBuilder logstringBuilder = new StringBuilder();

        if (requestAttribute != null && requestAttribute instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttribute).getRequest();
            Cookie[] cookies = request.getCookies();
            logstringBuilder.append(" Request Url: " + request.getRequestURL().toString() + "\n");
            logstringBuilder.append(" Request Referer Header: " + request.getHeader(HttpHeaders.REFERER) + "\n");
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    logstringBuilder
                            .append(" Cookie name: " + cookie.getName() + " Cookie value: " + cookie.getValue() + "\n");
                }
            }
        }
        logger.error("Logging request details for JesssionId\n" + logstringBuilder.toString());
    }
}