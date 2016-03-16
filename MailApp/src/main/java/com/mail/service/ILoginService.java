package com.mail.service;

import com.mail.TO.ResponseObject;
import com.mail.TO.UserLogin;

public interface ILoginService {

	public ResponseObject login(UserLogin user);
}
