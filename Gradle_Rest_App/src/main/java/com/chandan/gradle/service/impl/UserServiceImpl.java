package com.chandan.gradle.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.chandan.gradle.request.UserRequest;
import com.chandan.gradle.response.UserResponse;

@Service
public class UserServiceImpl implements IUserService {
	
	@Override
	public UserResponse getDummyData(UserRequest request) {
		UserResponse response = new UserResponse();
		response.setUserId(100123L);
		response.setRequest(request);
		response.setCode("200");
		response.setStatus("Success");
		response.setCreatedDate(new Date());
		response.setUpdateDate(new Date());
		
		return response;
	}
	
	

}
