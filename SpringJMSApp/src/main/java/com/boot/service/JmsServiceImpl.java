package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JmsServiceImpl implements IJmsService {

	@Autowired
	private ConsumerComp consumer;
	
	@Autowired
	private ProducerComp producer;
	
	@Override
	public void sendTxt(String msg) {
		producer.sendMessage(msg);
		
	}

	@Override
	public String receiveTxt() {
		return consumer.receive();
	}

}
