package org.test.falcon.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.falcon.model.SurveyLead;

@Repository
public interface SurveyLeadDao extends JpaRepository<SurveyLead, Integer> {

}
