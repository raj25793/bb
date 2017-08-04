package org.test.falcon.service;

import java.util.List;

import org.test.falcon.mongo.document.ChildDevice;
import org.test.falcon.mongo.document.Device;
import org.test.falcon.mongo.document.Lead;

public interface SurveyLeadService {

    Lead insertLead(Lead surveyLead);

    List<Lead> getLeadsOfUser(String userId);

    List<Device> getDevices(String userId, String leadId);

    List<ChildDevice> getChildDevices(String userId, String leadId, String masterDevId);

}
