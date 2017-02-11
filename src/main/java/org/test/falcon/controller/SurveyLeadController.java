package org.test.falcon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.model.SurveyLead;
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
    @RequestMapping(value = "survey-lead", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse insertSurveyLead(@RequestBody SurveyLead surveyLead) {
        SurveyLead sl = surveyLeadService.insertLead(surveyLead);
        return new GenericApiResponse(sl);
    }

}
