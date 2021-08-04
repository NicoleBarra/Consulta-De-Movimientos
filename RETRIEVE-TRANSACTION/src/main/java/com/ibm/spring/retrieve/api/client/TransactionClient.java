package com.ibm.spring.retrieve.api.client;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ibm.spring.retrieve.api.dto.TransactionResponse;
import com.ibm.spring.retrieve.api.model.TransactionRequest;

@FeignClient("RETRIEVE-CURRENT-TRANSACTION")
public interface TransactionClient {
  
  @PostMapping(value="/retrieve-current-information",consumes= MediaType.APPLICATION_JSON_VALUE)
  public List<TransactionResponse> getTransactions(@RequestBody TransactionRequest request );  

}
