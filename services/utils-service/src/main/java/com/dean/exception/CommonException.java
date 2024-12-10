package com.dean.exception;

public class CommonException extends RuntimeException {

  public CommonException(String message) {
    super(message);
  }

  public static CommonException of(String message) {
    return new CommonException(message);
  }
}
