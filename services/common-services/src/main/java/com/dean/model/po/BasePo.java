package com.dean.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BasePo {

  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  @TableField(fill = FieldFill.INSERT)
  private String createUser;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateUser;
}
