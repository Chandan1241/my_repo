package com.boot.swagger.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.swagger.service.IPersonService;
import com.boot.swagger.to.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/person", description = "Boot - Swagger Person COntroller")
@RequestMapping(value =  "/person" )
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private IPersonService personService;

	@ApiOperation(value = "GET Person Data By SSN")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfull Data"),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "URL details do not exist"), })
	@RequestMapping(value = "/getPersonDetailsBySSN/{ssn}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Person getPersonDetailsBySSN(@PathVariable String ssn, HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.info("Started executing getPersonDetailsBySSN() for SSN :" + ssn);
		return personService.getPersonDetailsBySSN(ssn);
	}

}
