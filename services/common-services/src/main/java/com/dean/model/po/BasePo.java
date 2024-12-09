package com.dean.model.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BasePo {

  private Date createDate;
  private Date updateDate;
  private String createUser;
  private String updateUser;
  @TableLogic
  private Integer isDeleted;
}
