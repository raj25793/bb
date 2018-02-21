package org.test.falcon.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.contract.model.Contract;
import org.test.falcon.contract.service.ContractService;
import org.test.falcon.pojo.response.GenericApiResponse;

@Controller
@RequestMapping(value = "/v1/")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/contract", method = RequestMethod.GET)
    @ResponseBody
    public GenericApiResponse getContract(@RequestParam Integer projectId) {
        return new GenericApiResponse(contractService.getContract(projectId));
    }

    @RequestMapping(value = "/contract", method = RequestMethod.POST)
    @ResponseBody
    public GenericApiResponse postContract(@RequestBody Contract contract) {
        return new GenericApiResponse(contractService.postContract(contract));
    }
}
