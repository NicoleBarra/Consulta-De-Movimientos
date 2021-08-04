package com.ibm.spring.retrieve.api.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ibm.spring.retrieve.api.client.TransactionClient;
import com.ibm.spring.retrieve.api.exception.InvalidFormatTransactionDateEndException;
import com.ibm.spring.retrieve.api.exception.InvalidFormatTransactionDateStartException;
import com.ibm.spring.retrieve.api.exception.NoAccountIdException;
import com.ibm.spring.retrieve.api.exception.NoBranchIdException;
import com.ibm.spring.retrieve.api.exception.NoTransactionDateEndException;
import com.ibm.spring.retrieve.api.exception.NoTransactionDateStartException;
import com.ibm.spring.retrieve.api.exception.TransactionsNotFoundException;
import com.ibm.spring.retrieve.api.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalHandleException {
  
  @ExceptionHandler(value = NoAccountIdException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoAccountIdException(HttpServletRequest req, NoAccountIdException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoAccountIdException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("AccountId in ResponseBody has a null value or is empty.");
    
    return errorResponse;
    
  }
  
  @ExceptionHandler(value = NoBranchIdException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoBranchIdException(HttpServletRequest req, NoBranchIdException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoBranchIdException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("BranchId in ResponseBody has a null value or is empty.");
    
    return errorResponse;
    
  }
  
  @ExceptionHandler(value = NoTransactionDateStartException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoBranchIdException(HttpServletRequest req, NoTransactionDateStartException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoTransactionDateStartException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("TransactionDateStart in ResponseBody has a null value or is empty.");
    
    return errorResponse;
    
  }
  
  @ExceptionHandler(value = NoTransactionDateEndException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoBranchIdException(HttpServletRequest req, NoTransactionDateEndException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoTransactionDateEndException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("TransactionDateEnd in ResponseBody has a null value or is empty.");
    
    return errorResponse;
    
  }
  
  @ExceptionHandler(value = InvalidFormatTransactionDateStartException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoBranchIdException(HttpServletRequest req, InvalidFormatTransactionDateStartException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("InvalidFormatTransactionDateStartException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("The data for the transaction start date is in an invalid format. Valid Format: (DD-MM-YYY)");
    
    return errorResponse;
    
  }
  
  @ExceptionHandler(value = InvalidFormatTransactionDateEndException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoBranchIdException(HttpServletRequest req, InvalidFormatTransactionDateEndException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("InvalidFormatTransactionDateEndException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("The data for the transaction end date is in an invalid format. Valid Format: (DD-MM-YYY)");
    
    return errorResponse;
    
  }
  
  @ExceptionHandler(value = TransactionsNotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoBranchIdException(HttpServletRequest req, TransactionsNotFoundException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("TransactionsNotFoundException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveTransactionController.class.getSimpleName());
    errorResponse.setMoreInfo("The data received didn't match with any transaction in our database.");
    
    return errorResponse;
    
  }
  
  

}
