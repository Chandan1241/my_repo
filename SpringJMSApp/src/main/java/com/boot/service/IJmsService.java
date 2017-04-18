package com.boot.service;

public interface IJmsService {

	void sendTxt(String msg);

	String receiveTxt();

}
