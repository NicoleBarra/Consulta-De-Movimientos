package com.ibm.spring.retrieve.current.api.model;

import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDescription {
  
  @Field("TransactionType")
  private String transactionType;
  
  @Field("Descripcion")
  private String descripcion;
  
  @Field("amount")
  private double amount;

}
