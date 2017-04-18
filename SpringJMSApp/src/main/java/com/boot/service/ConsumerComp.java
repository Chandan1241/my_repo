package com.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComp {

	private String destinationQueue = "spring.jms.queue";

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerComp.class);
	@Autowired
	private JmsTemplate jmsTemplate;

	public String receive() {
		LOGGER.info("Receive message from  destinationQueue : " + destinationQueue);
		return (String) jmsTemplate.receiveAndConvert(destinationQueue);
	}

	@JmsListener(destination = "spring.jms.queue")
	public void receiveListner() {
		try {
			LOGGER.info("########### Recevied Text ::::::: " + jmsTemplate.receiveAndConvert(destinationQueue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
