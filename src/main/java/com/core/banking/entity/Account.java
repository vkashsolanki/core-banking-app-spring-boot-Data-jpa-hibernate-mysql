package com.core.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column(name = "account_holder_name")
	private String accoutHolderName;
	private double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long id, String accoutHolderName, double balance) {
		super();
		this.id = id;
		this.accoutHolderName = accoutHolderName;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccoutHolderName() {
		return accoutHolderName;
	}

	public void setAccoutHolderName(String accoutHolderName) {
		this.accoutHolderName = accoutHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
