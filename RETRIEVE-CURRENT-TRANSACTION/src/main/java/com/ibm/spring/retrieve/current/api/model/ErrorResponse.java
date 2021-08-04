package com.ibm.spring.retrieve.current.api.model;

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
