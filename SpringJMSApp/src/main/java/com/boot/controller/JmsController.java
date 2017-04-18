package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.IJmsService;

@RestController
public class JmsController {
	@Autowired
	private IJmsService jsmClient;

	@RequestMapping(value = "/send")
	public void produce(@RequestParam("msg") String msg) {
		jsmClient.sendTxt(msg);
	}

	@RequestMapping(value = "/receive")
	public String receive() {
		return jsmClient.receiveTxt();
	}

}
