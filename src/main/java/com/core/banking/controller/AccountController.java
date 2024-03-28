package com.core.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.banking.dto.AccountDto;
import com.core.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

//add account for restapi
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {

		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

	// get account by id
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);

	}

	// Deposit Amount
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id, amount);

		return ResponseEntity.ok(accountDto);
	}

	// withdraw amount
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");

		AccountDto accountDto = accountService.withdraw(id, amount);

		return ResponseEntity.ok(accountDto);

	}
	
	//get all Account
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		
		List<AccountDto> list = accountService.getAllAccount();
		
		return ResponseEntity.ok(list);
		
	}
	
	//delete Accounts
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccounts(@PathVariable long id){
		
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account has been deleted Successfully !!..");
		
		
	}
	

}
