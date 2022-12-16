package com.example.services;

import java.util.List;

import com.example.models.Product;

public interface IAthenaService {
  String submitQuery(String myQuery);
  void waitForQueryToComplete(String queryExecutionId);
    List<Product> processQueryResult(String queryExecutionId);
}
