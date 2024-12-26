package com.kafka.producer;

import com.kafka.producer.Service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static java.lang.Long.*;

@SpringBootApplication
public class ProducerApplication {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(ProducerApplication.class, args);

	}

	@Bean
	CommandLineRunner run(KafkaProducerService kafkaProducerService) {
		return args -> {
			// Example of publishing messages
			for (int i = 1; i <= 100000; i++) {
				kafkaProducerService.sendMessage(
						"{\"employeeId\":\"E" + i + "\", \"name\":\"Employee " + i + "\", \"designation\":\"Designation " + i + "\", \"department\":\"Department " + (i % 10) + "\", \"dateOfJoining\":\"2023-01-01\"}"
				);
			}
		};
	}

}
