package org.test.falcon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.falcon.pojo.response.GenericApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "v1/")
@Api(value = "syncs the device with server")
public class SyncController {

	@ApiOperation(value = "sync", notes = "checks if server is in sync with device")
	@RequestMapping(value = "sync", method = RequestMethod.GET)
	@ResponseBody
	public GenericApiResponse isInSync(){
		return new GenericApiResponse(true);
	}
	
}
