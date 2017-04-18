package com.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerComp {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerComp.class);
	
	private String destinationQueue = "spring.jms.queue";
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(String message) {
		LOGGER.info("Send message to  destination : " + destinationQueue);
		jmsTemplate.convertAndSend(destinationQueue, message);
		LOGGER.info("Successfully Sent message to  destination : " + destinationQueue);
	}

}
