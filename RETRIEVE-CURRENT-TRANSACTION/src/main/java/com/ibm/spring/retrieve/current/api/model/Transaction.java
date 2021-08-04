package com.ibm.spring.retrieve.current.api.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="Transactions")
public class Transaction {
  
  private int customerId;
  private String date;
  private TransactionDescription transactionDescription;
  

}
