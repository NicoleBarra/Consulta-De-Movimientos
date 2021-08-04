package com.ibm.spring.retrieve.current.api.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.ibm.spring.retrieve.current.api.model.Transaction;

@Repository
public interface RetrieveCurrentRepository extends MongoRepository<Transaction, String> {

  @Query("{'customerId':?0}")
  List<Transaction> getTransactionsWithCustomerId(int customerId);
}
