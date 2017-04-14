package com.chandan.gradle.service.impl;

import com.chandan.gradle.request.UserRequest;
import com.chandan.gradle.response.UserResponse;

public interface IUserService {

	UserResponse getDummyData(UserRequest request);
}
