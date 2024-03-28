package com.core.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.banking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
