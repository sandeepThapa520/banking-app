package com.learning_spring.banking_app.controller;


import com.learning_spring.banking_app.dto.AccountDto;
import com.learning_spring.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // used for restful web service
@RequestMapping("/api/account")
public class AccountContoller {
    private AccountService accountService;
    public AccountContoller(AccountService accountService) {
        this.accountService = accountService;
    }

    // creating account rest api
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

}
