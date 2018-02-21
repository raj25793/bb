package org.test.falcon.contract.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.falcon.contract.model.Contract;

@Repository
public interface ContractDao extends JpaRepository<Contract, Integer> {

    Contract findByProjectId(Integer projectId);

}
