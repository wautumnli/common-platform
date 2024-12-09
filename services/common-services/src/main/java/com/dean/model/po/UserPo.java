package com.dean.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("account_tb")
public class UserPo extends BasePo {

  @TableId(type = IdType.AUTO)
  private Long accountId;
  private String account;
  private String password;
  private String nickName;
}
