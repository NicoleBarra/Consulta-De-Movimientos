package com.ibm.spring.retrieve.current.api.controller;

import java.text.ParseException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.spring.retrieve.current.api.exception.NoCustomerIdException;
import com.ibm.spring.retrieve.current.api.exception.NoTransactionDateEndException;
import com.ibm.spring.retrieve.current.api.exception.NoTransactionDateStartException;
import com.ibm.spring.retrieve.current.api.model.RetrieveRequest;
import com.ibm.spring.retrieve.current.api.model.Transaction;
import com.ibm.spring.retrieve.current.api.service.RetrieveCurrentService;

@RestController
public class RetrieveCurrentController {
  
  @Autowired
  private RetrieveCurrentService service;
  
  private static Logger log = LoggerFactory.getLogger(RetrieveCurrentController.class);
  
  @PostMapping(      value = "/retrieve-current-information",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<Transaction> getTransactions(@RequestBody RetrieveRequest req) throws ParseException{
    
    if(req.getCustomerId() == null) {
      throw new NoCustomerIdException("");
    }
    
    if(req.getTransactionDateStart() == null || req.getTransactionDateStart().isEmpty()) {
      throw new NoTransactionDateStartException("");
    }
    
    if(req.getTransactionDateEnd() == null || req.getTransactionDateEnd().isEmpty()) {
      throw new NoTransactionDateEndException("");
    }
    
    List<Transaction> trans = service.getTransactionsService(req.getCustomerId(), req.getTransactionDateStart(), req.getTransactionDateEnd());
    
    return trans;
  }

}
