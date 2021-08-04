package com.ibm.spring.retrieve.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
  
  private String type;
  private int code;
  private String location;
  private String moreInfo;
  

}
