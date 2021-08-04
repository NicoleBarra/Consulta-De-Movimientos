package com.ibm.spring.retrieve.current.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetrieveRequest {
  
  @JsonProperty("customerId")
  private Integer customerId;
  
  @JsonProperty("transactionDateStart")
  private String transactionDateStart;
  
  @JsonProperty("transactionDateEnd")
  private String transactionDateEnd;
  
  public RetrieveRequest() {
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
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

  public RetrieveRequest(Integer customerId, String transactionDateStart,
      String transactionDateEnd) {
    super();
    this.customerId = customerId;
    this.transactionDateStart = transactionDateStart;
    this.transactionDateEnd = transactionDateEnd;
  }
  
  
  
  
}
