package org.test.falcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.falcon.exception.ProAPIException;
import org.test.falcon.model.SurveyLead;
import org.test.falcon.mysql.dao.SurveyLeadDao;
import org.test.falcon.service.SurveyLeadService;

@Service
public class SurveyLeadServiceImpl implements SurveyLeadService {

    @Autowired
    private SurveyLeadDao surveyLeadDao;

    @Override
    public SurveyLead insertLead(SurveyLead surveyLead) {
        try {
            SurveyLead sl = surveyLeadDao.save(surveyLead);
            return sl;
        }
        catch (Exception e) {
            throw new ProAPIException("unable to save this survey lead.", e);
        }
    }

}
