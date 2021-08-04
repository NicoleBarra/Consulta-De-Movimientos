package com.ibm.spring.retrieve.current.api.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ibm.spring.retrieve.current.api.exception.NoCustomerIdException;
import com.ibm.spring.retrieve.current.api.exception.NoTransactionDateEndException;
import com.ibm.spring.retrieve.current.api.exception.NoTransactionDateStartException;
import com.ibm.spring.retrieve.current.api.model.ErrorResponse;

@RestControllerAdvice
public class GlobalHandleException {
  
  @ExceptionHandler(value= NoCustomerIdException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoCustomerIdException(HttpServletRequest req, NoCustomerIdException e) {
ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoCustomerIdException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveCurrentController.class.getSimpleName());
    errorResponse.setMoreInfo("CustomerId in ResponseBody has a null value or is empty.");
    
    return errorResponse;
  }
  
  @ExceptionHandler(value= NoTransactionDateStartException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoCustomerIdException(HttpServletRequest req, NoTransactionDateStartException e) {
ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoTransactionDateStartException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveCurrentController.class.getSimpleName());
    errorResponse.setMoreInfo("TransactionDateStart in ResponseBody has a null value or is empty.");
    
    return errorResponse;
  }
  
  @ExceptionHandler(value= NoTransactionDateEndException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveNoCustomerIdException(HttpServletRequest req, NoTransactionDateEndException e) {
ErrorResponse errorResponse = new ErrorResponse();
    
    errorResponse.setType("NoTransactionDateEndException");
    errorResponse.setCode(400);
    errorResponse.setLocation(RetrieveCurrentController.class.getSimpleName());
    errorResponse.setMoreInfo("TransactionDateEnd in ResponseBody has a null value or is empty.");
    
    return errorResponse;
  }

}
