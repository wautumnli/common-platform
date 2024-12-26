package com.dean;

import com.dean.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@SpringBootTest
public class DbTest {

  @Resource
  private AccountMapper userMapper;

  @Test
  void testInsert() {
    ZoneId zoneId = ZoneOffset.UTC;
    LocalDateTime time = LocalDate.now(zoneId).atStartOfDay();
    System.out.println(time);
  }
}
