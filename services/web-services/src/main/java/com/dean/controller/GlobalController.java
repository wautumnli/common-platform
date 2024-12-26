package com.dean.controller;

import com.dean.common.Result;
import com.dean.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalController {

  @ExceptionHandler(CommonException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result handleCommonException(CommonException e) {
    return Result.fail(e.getMessage());
  }
}
