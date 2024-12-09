package com.dean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dean.mapper")
public class ServiceEntrance {

  public static void main(String[] args) {
    SpringApplication.run(ServiceEntrance.class, args);
  }
}
