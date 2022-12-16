package com.example.lambdaverifystock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.configurations.AthenaClientFactory;
import com.example.constants.Constants;
import com.example.services.AthenaOrchestrator;
import com.example.services.AthenaService;

import software.amazon.awssdk.services.athena.AthenaClient;

@SpringBootApplication
public class LambdaVerifyStockApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(LambdaVerifyStockApplication.class);
	private String defaultQuery = Constants.ATHENA_SAMPLE_QUERY;

	public static void main(String[] args) {
		SpringApplication.run(LambdaVerifyStockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AthenaClientFactory factory = new AthenaClientFactory();
		AthenaClient athenaClient = factory.createClientDev();
		AthenaService athenaQueryExecutor = new AthenaService(athenaClient);

		logger.info("Initializing Athena Orchestrator");
		AthenaOrchestrator orchestrator = new AthenaOrchestrator(defaultQuery, athenaQueryExecutor);
		logger.info("Executing Athena Orchestrator");
		orchestrator.execute();
	}

}
