package com.boot.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@SpringBootApplication
@ComponentScan("com.boot")
@EnableJms
public class SpringJmsApplication {
	@Autowired
	ConnectionFactory connectionFactory;

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsApplication.class, args);
	}
	
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
            DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
            factory.setConnectionFactory(connectionFactory);
            factory.setConcurrency("1-1");
            return factory;
    }
    
     
 
}
