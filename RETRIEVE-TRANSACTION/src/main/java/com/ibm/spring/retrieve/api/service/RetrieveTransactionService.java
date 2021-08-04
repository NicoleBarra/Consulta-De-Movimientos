package com.ibm.spring.retrieve.api.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.spring.retrieve.api.client.TransactionClient;
import com.ibm.spring.retrieve.api.controller.RetrieveTransactionController;
import com.ibm.spring.retrieve.api.dto.TransactionResponse;
import com.ibm.spring.retrieve.api.model.RetrieveRequest;
import com.ibm.spring.retrieve.api.model.TransactionRequest;

@Service
public class RetrieveTransactionService {
  
  @Autowired
  private TransactionClient client;
  
  private static Logger log = LoggerFactory.getLogger(RetrieveTransactionController.class);
  
  public List<TransactionResponse> retrieveTransaction(RetrieveRequest req) {
    
    log.debug("Entering Service....");
    
    int customerId = Integer.parseInt(req.getAccountId().toString().substring(0,3) + req.getBranchId().toString().substring(0, 3));
    log.info("customerId: " + customerId);
    
    TransactionRequest tranReq = new TransactionRequest(customerId, req.getTransactionDateStart(), req.getTransactionDateEnd());
    
    List<TransactionResponse> response = client.getTransactions(tranReq);
    
    return response;
    
    
    
  
  }

}
