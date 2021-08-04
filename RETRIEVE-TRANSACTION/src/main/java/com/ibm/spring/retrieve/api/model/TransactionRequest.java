package com.ibm.spring.retrieve.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


public class TransactionRequest {
  @JsonProperty("customerId")
  private int customerId;
  
  @JsonProperty("transactionDateStart")
  private String transactionDateStart;
  
  @JsonProperty("transactionDateEnd")
  private String transactionDateEnd;

  public TransactionRequest() {
  }

  public TransactionRequest(int customerId, String transactionDateStart,
      String transactionDateEnd) {
    super();
    this.customerId = customerId;
    this.transactionDateStart = transactionDateStart;
    this.transactionDateEnd = transactionDateEnd;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getTransactionDateStart() {
    return transactionDateStart;
  }

  public void setTransactionDateStart(String transactionDateStart) {
    this.transactionDateStart = transactionDateStart;
  }

  public String getTransactionDateEnd() {
    return transactionDateEnd;
  }

  public void setTransactionDateEnd(String transactionDateEnd) {
    this.transactionDateEnd = transactionDateEnd;
  }
  
  
  
  
  
  

}
