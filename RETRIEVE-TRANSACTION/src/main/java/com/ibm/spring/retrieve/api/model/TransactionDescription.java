package com.ibm.spring.retrieve.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDescription {

  @JsonProperty("transactionType")
  private String transactionType;
  @JsonProperty("descripicion")
  private String descripcion;
  @JsonProperty("amount")
  private double amount;
}
