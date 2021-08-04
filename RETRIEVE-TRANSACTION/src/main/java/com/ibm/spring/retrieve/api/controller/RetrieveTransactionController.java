package com.ibm.spring.retrieve.api.controller;

import java.util.List;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.spring.retrieve.api.dto.TransactionResponse;
import com.ibm.spring.retrieve.api.exception.InvalidFormatTransactionDateEndException;
import com.ibm.spring.retrieve.api.exception.InvalidFormatTransactionDateStartException;
import com.ibm.spring.retrieve.api.exception.NoAccountIdException;
import com.ibm.spring.retrieve.api.exception.NoBranchIdException;
import com.ibm.spring.retrieve.api.exception.NoTransactionDateEndException;
import com.ibm.spring.retrieve.api.exception.NoTransactionDateStartException;
import com.ibm.spring.retrieve.api.exception.TransactionsNotFoundException;
import com.ibm.spring.retrieve.api.model.RetrieveRequest;
import com.ibm.spring.retrieve.api.service.RetrieveTransactionService;

@RestController

public class RetrieveTransactionController {
  
  private static Pattern DATE_PATTERN = Pattern.compile(
      "^\\d{2}-\\d{2}-\\d{4}$");
  
  private static Logger log = LoggerFactory.getLogger(RetrieveTransactionController.class);
  
  @Autowired
  private RetrieveTransactionService service;
  
  @PostMapping(
      value = "/retrieve-transaction-user",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public @ResponseBody List<TransactionResponse> postController(@RequestBody RetrieveRequest request) {
    log.debug("Received Retrieve Transaction Request from response body...");
    
    if(request.getAccountId() == null) {
      throw new NoAccountIdException("");
    }
    
    if(request.getBranchId() == null) {
      throw new NoBranchIdException("");
    }
    
    if(request.getTransactionDateStart() == null || request.getTransactionDateStart().isEmpty()) {
      throw new NoTransactionDateStartException("");
    }
    
    if(request.getTransactionDateEnd() == null || request.getTransactionDateEnd().isEmpty()) {
      throw new NoTransactionDateEndException("");
    }
    
    if(DATE_PATTERN.matcher(request.getTransactionDateStart()).matches() == false) {
      throw new InvalidFormatTransactionDateStartException("");
    }
    
    if(DATE_PATTERN.matcher(request.getTransactionDateEnd()).matches() == false) {
      throw new InvalidFormatTransactionDateEndException("");
    }
    
    List<TransactionResponse> response = service.retrieveTransaction(request);
    
    if(response.isEmpty()) {
      throw new TransactionsNotFoundException("");
    }
    
    return response;
  }
  

}
