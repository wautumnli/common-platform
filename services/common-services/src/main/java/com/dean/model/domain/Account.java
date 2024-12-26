package com.dean.model.domain;

import lombok.Data;

@Data
public class Account {

  private Long accountId;
  private String account;
  private String password;
  private String nickName;
}
