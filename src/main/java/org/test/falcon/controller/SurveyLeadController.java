package org.test.falcon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.exception.ProAPIException;
import org.test.falcon.mongo.document.ChildDevice;
import org.test.falcon.mongo.document.Device;
import org.test.falcon.mongo.document.Lead;
import org.test.falcon.pojo.response.GenericApiResponse;
import org.test.falcon.service.SurveyLeadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/v1")
@Api(value = "survey-lead")
public class SurveyLeadController {

    @Autowired
    private SurveyLeadService surveyLeadService;

    @ApiOperation(value = "survey-lead", notes = "insert a new survey lead in db")
    @RequestMapping(value = "/survey-lead", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse insertSurveyLead(@RequestBody Lead surveyLead) {
        if (surveyLead != null) {
            Lead sl = surveyLeadService.insertLead(surveyLead);
            return new GenericApiResponse(sl);
        }
        else {
            throw new ProAPIException("SurveyLead Object cannot be null");
        }

    }

    @ApiOperation(value = "survey-lead", notes = "insert a new survey lead in db")
    @RequestMapping(value = "/survey-lead", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getLeads(@RequestParam String userId) {
        List<Lead> leads = surveyLeadService.getLeadsOfUser(userId);
        return new GenericApiResponse(leads);

    }

    @ApiOperation(value = "survey-lead", notes = "insert a new survey lead in db")
    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getDevices(@RequestParam String leadId, @RequestParam String userId) {
        List<Device> devices = surveyLeadService.getDevices(userId, leadId);
        return new GenericApiResponse(devices);
    }

    @ApiOperation(value = "survey-lead", notes = "insert a new survey lead in db")
    @RequestMapping(value = "/child-devices", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getDevices(
            @RequestParam String deviceId,
            @RequestParam String leadId,
            @RequestParam String userId) {
        List<ChildDevice> devices = surveyLeadService.getChildDevices(userId, leadId, deviceId);
        return new GenericApiResponse(devices);
    }

}
