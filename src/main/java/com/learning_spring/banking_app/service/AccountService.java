package com.learning_spring.banking_app.service;

import com.learning_spring.banking_app.dto.AccountDto;
import com.learning_spring.banking_app.entity.Account;
import com.learning_spring.banking_app.mapper.AccountMapper;
import com.learning_spring.banking_app.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //creating new account
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto); //mapping to account
        Account saveAccount = accountRepository.save(account);   // using account repository to save account in the database

        return AccountMapper.mapToAccountDto(saveAccount);
    }
}
