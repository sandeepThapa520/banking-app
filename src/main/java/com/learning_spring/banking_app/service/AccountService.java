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

    //fetching accounts by id
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    //depositing to account
    public AccountDto accountDeposite(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        double total_balance = account.getBalance() + amount;
        account.setBalance(total_balance);
        Account depositedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(depositedAccount);
    }


}
