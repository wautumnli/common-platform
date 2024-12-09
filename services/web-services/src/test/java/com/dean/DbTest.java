package com.dean;

import com.dean.mapper.UserMapper;
import com.dean.model.po.UserPo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class DbTest {

  @Resource
  private UserMapper userMapper;

  @Test
  void testInsert() {
    UserPo userPo = new UserPo();
    userPo.setAccount("test");
    userPo.setPassword("test");
    userPo.setNickName("test");
    userPo.setCreateUser("test");
    userPo.setUpdateUser("test");
    userMapper.insert(userPo);
  }
}
