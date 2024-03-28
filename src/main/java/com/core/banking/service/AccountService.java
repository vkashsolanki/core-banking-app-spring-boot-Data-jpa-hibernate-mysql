package com.core.banking.service;

import java.util.List;

import com.core.banking.dto.AccountDto;

public interface AccountService {
	
	//add account
	AccountDto createAccount(AccountDto accountDto);
	
	//get accounts by id
	AccountDto getAccountById(long id);
	
	//deposit amount
	
	AccountDto deposit(long id, double amount);
	
	//withdrow amount
	
	AccountDto withdraw(long id, double withdrowAmount);
	
	// get All Account
	
	List<AccountDto> getAllAccount();
	
	// delete accounts
	void deleteAccount(long id);
		
	
		

	
	
	
	
	

}
