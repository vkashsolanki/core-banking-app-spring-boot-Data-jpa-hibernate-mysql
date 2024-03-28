package com.core.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.banking.dto.AccountDto;
import com.core.banking.entity.Account;
import com.core.banking.mapper.AccountMapper;
import com.core.banking.repository.AccountRepository;
import com.core.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired // or generate consector
	private AccountRepository accountRepository;

	public AccountDto createAccount(AccountDto accountDto) {

		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(long id) {
		Account accounts = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		return AccountMapper.mapToAccountDto(accounts);
	}

	@Override
	public AccountDto deposit(long id, double amount) {

		Account accounts = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));

		double total = accounts.getBalance() + amount;
		accounts.setBalance(total);
		Account savedAccount = accountRepository.save(accounts);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(long id, double withdrowAmount) {
		Account accounts = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));

		if (accounts.getBalance() < withdrowAmount) {
			throw new RuntimeException("Insufficiant Amount");
		}

		double total = accounts.getBalance() - withdrowAmount;
		accounts.setBalance(total);

		Account savedAccount = accountRepository.save(accounts);

		return AccountMapper.mapToAccountDto(savedAccount);

	}

	@Override
	public List<AccountDto> getAllAccount() {
		List<Account> accounts = accountRepository.findAll();
		// pass the account entity parameter for lambda exp.
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(long id) { 
		
		Account accounts = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		
		
		accountRepository.deleteById(id);
	}

}

























