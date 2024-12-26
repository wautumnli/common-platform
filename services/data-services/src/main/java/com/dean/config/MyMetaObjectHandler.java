package com.dean.config;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
    this.strictInsertFill(metaObject, "createUser", String.class,
        getOperator());
    this.strictInsertFill(metaObject, "updateUser", String.class,
        getOperator());
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    this.strictUpdateFill(metaObject, "updateUser", String.class,
        getOperator());
  }

  private String getOperator() {
    if (StpUtil.isLogin() && StpUtil.getLoginIdDefaultNull() != null) {
      return StpUtil.getLoginIdAsString();
    }
    return "system";
  }
}
