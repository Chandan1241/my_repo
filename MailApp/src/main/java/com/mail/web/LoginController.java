package com.mail.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mail.TO.ResponseObject;
import com.mail.TO.UserLogin;
import com.mail.service.ILoginService;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseObject login(@RequestBody UserLogin user, HttpServletRequest req,
			HttpServletResponse res) {
		ResponseObject resp = loginService.login(user);
		if (HttpStatus.BAD_REQUEST.value() == resp.getStatus()) {
			res.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		return resp;
	}
}
