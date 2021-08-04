package com.ibm.spring.retrieve.current.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.spring.retrieve.current.api.dao.RetrieveCurrentRepository;
import com.ibm.spring.retrieve.current.api.model.Transaction;

@Service
public class RetrieveCurrentService {
  
  @Autowired
  private RetrieveCurrentRepository repo;
  
  public List<Transaction> getTransactionsService(int customerId, String start, String end) throws ParseException{
    
    Date startDate = new SimpleDateFormat("dd-MM-yyyy").parse(start);
    Date endDate = new SimpleDateFormat("dd-MM-yyyy").parse(end);
    
    
    List<Transaction> trans = repo.getTransactionsWithCustomerId(customerId);
    
    List<Transaction> res = new ArrayList<Transaction>();
    
    for(int i = 0; i < trans.size(); i++) {
      
      Transaction temp = trans.get(i);
      
      Date transactionDate = new SimpleDateFormat("dd-MM-yyyy").parse(temp.getDate());
      
      if(!transactionDate.before(transactionDate) && !transactionDate.after(endDate)) {
        res.add(temp);  
      }
      
    }
    
    return res;
  }

}
