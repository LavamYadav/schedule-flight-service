package com.cg.fms;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.AbstractEnvironment;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class ScheduleFlightServiceApplication {

	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(ScheduleFlightServiceApplication.class);
	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		logger.info("Starting Application.");
		SpringApplication.run(ScheduleFlightServiceApplication.class, args);
		logger.info("Application Running");
	}

}
