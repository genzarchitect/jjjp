package com.stackroute;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(LoginServiceApplication.class, args);
		System.out.println("application running");
	}

}
