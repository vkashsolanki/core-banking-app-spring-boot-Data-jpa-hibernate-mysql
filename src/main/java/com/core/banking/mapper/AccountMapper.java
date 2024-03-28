package com.core.banking.mapper;

import com.core.banking.dto.AccountDto;
import com.core.banking.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {

		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());

		return account;

	}

	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(), account.getAccoutHolderName(),account.getBalance());
		
		
		return accountDto;
		
	}
	
}
