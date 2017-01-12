package org.test.falcon.exception;

/**
 * @author Rajeev Pandey
 * 
 */
public interface APIException {

    public String getResponseCode();

    public void setResponseCode(String code);
}
