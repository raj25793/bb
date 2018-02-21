package org.test.falcon.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.falcon.contract.dao.ContractDao;
import org.test.falcon.contract.model.Contract;

@Service
public class ContractService {

    @Autowired
    private ContractDao contractDao;

    public Contract getContract(Integer projectId) {
        return contractDao.findByProjectId(projectId);
    }

    public Contract postContract(Contract contract) {
        return contractDao.save(contract);
    }

}
