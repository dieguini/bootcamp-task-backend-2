package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.models.Product;

public class AthenaOrchestrator {
  private static final Logger logger = LoggerFactory.getLogger(AthenaService.class);
  private final String query;
  private AthenaService athenaService;
  
  public AthenaOrchestrator(String query, AthenaService athenaService){
    this.query = query;
    this.athenaService = athenaService;
  }

  public List<Product> execute(){
    List<Product> productsList = new ArrayList<>();

    String queryExecutionId = this.athenaService.submitQuery(this.query);

    this.athenaService.waitForQueryToComplete(queryExecutionId);
    productsList = this.athenaService.processQueryResult(queryExecutionId);
    for(Product p:productsList){
      logger.info("Product = "+ p);
    }

    return productsList;
  }
}
