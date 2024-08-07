package com.learning_spring.banking_app.controller;


import com.learning_spring.banking_app.dto.AccountDto;
import com.learning_spring.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    //get account rest api
    @GetMapping("/get{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccount(id);
        return ResponseEntity.ok(accountDto);
    }

    //account deposite rest api
    @PutMapping("/deposite/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.accountDeposite(id, amount);
        return ResponseEntity.ok(accountDto);

    }

}
