package com.dean.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dean.exception.CommonException;
import com.dean.mapper.AccountMapper;
import com.dean.model.dto.AccountDto;
import com.dean.model.po.AccountPo;
import com.dean.model.transfer.account.AccountTransfer;
import com.dean.service.AccountService;
import com.dean.utils.CheckUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountPo>
    implements AccountService {

  @Resource
  private AccountMapper accountMapper;

  @Override
  public String login(@RequestBody AccountDto accountDto) {
    CheckUtils.check(accountDto, "username,password", "用户名或密码不能为空");

    QueryWrapper<AccountPo> query = getQueryWrapper().eq("account",
        accountDto.getUsername());
    List<AccountPo> accountPos = accountMapper.selectList(query);
    if (CollectionUtils.isEmpty(accountPos)) {
      throw new CommonException("用户名不存在");
    }
    AccountPo accountPo = accountPos.get(0);

    String inputPassword = accountDto.getPassword();
    inputPassword = SaSecureUtil.md5(inputPassword);
    if (!inputPassword.equals(accountPo.getPassword())) {
      throw new CommonException("密码错误");
    }

    StpUtil.login(accountPo.getAccountId());
    return StpUtil.getTokenValue();
  }

  @Override
  public String register(@RequestBody AccountDto accountDto) {
    CheckUtils.check(accountDto, "username,password", "用户名或密码不能为空");
    CheckUtils.check(accountDto, "nickName", "昵称不能为空");

    QueryWrapper<AccountPo> query = getQueryWrapper().select("account_id")
        .eq("account", accountDto.getUsername());
    List<AccountPo> accountPos = accountMapper.selectList(query);
    if (CollectionUtils.isNotEmpty(accountPos)) {
      throw new CommonException("用户名已存在");
    }

    AccountPo accountPo = AccountTransfer.INSTANCE.toAccountPo(accountDto);
    accountPo.setPassword(SaSecureUtil.md5(accountPo.getPassword()));
    int result = accountMapper.insert(accountPo);

    if (result == 0) {
      throw new CommonException("注册失败");
    }
    return "注册成功";
  }

  private QueryWrapper<AccountPo> getQueryWrapper() {
    return new QueryWrapper<>();
  }
}
