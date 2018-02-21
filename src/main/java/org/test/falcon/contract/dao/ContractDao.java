package org.test.falcon.contract.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.falcon.contract.model.Contract;

public interface ContractDao extends JpaRepository<Contract, Integer> {

    Contract findByProjectId(Integer projectId);

}
