package com.dean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dean.model.dto.AccountDto;
import com.dean.model.po.AccountPo;

public interface AccountService extends IService<AccountPo> {

  /**
   * 登陆
   *
   * @return token
   */
  String login(AccountDto accountDto);

  /**
   * 注册
   * @return msg 提示信息
   */
  String register(AccountDto accountDto);
}
