package com.dean.controller;

import com.dean.common.Result;
import com.dean.model.dto.AccountDto;
import com.dean.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Resource
  private AccountService accountService;

  @PostMapping("/login")
  public Result login(@RequestBody AccountDto accountDto) {
    String token = accountService.login(accountDto);
    return Result.success(token);
  }

  @PostMapping("/register")
  public Result register(@RequestBody AccountDto accountDto) {
    String msg = accountService.register(accountDto);
    return Result.success(msg);
  }

}
