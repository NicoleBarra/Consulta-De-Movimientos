package com.ibm.spring.retrieve.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


public class RetrieveRequest {
  
  @JsonProperty("accountId")
  private Integer accountId;
  
  @JsonProperty("branchId")
  private Integer branchId;
  
  @JsonProperty("transactionDateStart")
  private String transactionDateStart;
  
  @JsonProperty("transactionDateEnd")
  private String transactionDateEnd;

  public RetrieveRequest() {
  }

  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public Integer getBranchId() {
    return branchId;
  }

  public RetrieveRequest(Integer accountId, Integer branchId, String transactionDateStart,
      String transactionDateEnd) {
    super();
    this.accountId = accountId;
    this.branchId = branchId;
    this.transactionDateStart = transactionDateStart;
    this.transactionDateEnd = transactionDateEnd;
  }

  public void setBranchId(Integer branchId) {
    this.branchId = branchId;
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
