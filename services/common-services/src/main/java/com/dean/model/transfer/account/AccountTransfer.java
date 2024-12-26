package com.dean.model.transfer.account;

import com.dean.model.dto.AccountDto;
import com.dean.model.po.AccountPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountTransfer {

  AccountTransfer INSTANCE = Mappers.getMapper(AccountTransfer.class);

  @Mapping(source = "username", target = "account")
  AccountPo toAccountPo(AccountDto accountDto);
}
