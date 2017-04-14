package com.chandan.gradle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.gradle.request.UserRequest;
import com.chandan.gradle.response.UserResponse;
import com.chandan.gradle.service.impl.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/UserController", description = "Search User data and return User object")
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@PostMapping(name = "/searchUser")
	@ApiOperation(value = "POST: Get user data base on criteria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "URL details does not exist"), })
	public @ResponseBody UserResponse getUserDataByRequest(@RequestBody UserRequest request) {
		LOGGER.info("Calling service layer.......");
		return userService.getDummyData(request);
	}

	@DeleteMapping(name = "/deleteUserBySSN/{ssn}")
	@ApiOperation(value = "DELETE: Delete user data base on criteria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "URL details does not exist"), })
	public void deleteUser(@PathVariable("ssn") String ssn) {
		LOGGER.info("Calling service layer.......");
	}

	@GetMapping(name = "/getUser/{userId}")
	@ApiOperation(value = "GET: Get user data base on criteria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "URL details does not exist"), })
	public @ResponseBody UserResponse getUserData(@PathVariable("userId") Long userId) {
		LOGGER.info("Calling service layer.......");
		return new UserResponse();
	}

	@PutMapping(name = "/updateUser")
	@ApiOperation(value = "UPDATE: update user data base on criteria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "URL details does not exist"), })
	public @ResponseBody UserResponse deleteUser(@RequestBody UserRequest request) {
		LOGGER.info("Calling service layer.......");
		return userService.getDummyData(request);
	}

}
