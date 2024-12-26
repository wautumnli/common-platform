package com.dean.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result {

  private Object data;
  private int code;
  private String msg;

  public Result() {
  }

  public static Result success() {
    Result result = new Result();
    result.setCode(ResultCode.SUCCESS.code);
    result.setMsg(ResultCode.SUCCESS.message);
    return result;
  }

  public static Result success(String msg) {
    Result result = new Result();
    result.setCode(ResultCode.SUCCESS.code);
    result.setMsg(msg);
    return result;
  }

  public static Result fail(String msg) {
    Result result = new Result();
    result.setCode(ResultCode.FAIL.code);
    result.setMsg(msg);
    return result;
  }

  @Getter
  enum ResultCode {
    SUCCESS(200, "success"), FAIL(400, "fail");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
      this.code = code;
      this.message = message;
    }

  }
}
