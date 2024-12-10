package com.dean.common;

public class Results {

  private Object data;
  private int code;
  private String msg;


  public Results() {
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public static Results success() {
    Results results = new Results();
    results.setCode(ResultCode.SUCCESS.code);
    results.setMsg(ResultCode.SUCCESS.message);
    return results;
  }

  public static Results success(String msg) {
    Results results = new Results();
    results.setCode(ResultCode.SUCCESS.code);
    results.setMsg(msg);
    return results;
  }

  enum ResultCode {
    SUCCESS(200, "success"), FAIL(500, "fail");

    private int code;
    private String message;

    ResultCode(int code, String message) {
      this.code = code;
      this.message = message;
    }

    public int getCode() {
      return code;
    }

    public String getMessage() {
      return message;
    }
  }
}
