package com.example.usingtransactions.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.usingtransactions.Model.Accounts;
import com.example.usingtransactions.Service.TransferRequest;
import com.example.usingtransactions.Service.TransferService;

@RestController
public class AccountController {
 
    private final TransferService transferService;
 
  public AccountController(TransferService transferService) {
    this.transferService = transferService;
  }

  @PostMapping("/transfer")                  
  public void transferMoney(
      @RequestBody TransferRequest request   
      ) {
    transferService.transferMoney(           
        request.getSenderAccountId(),
        request.getReceiverAccountId(),
        request.getAmount());
  }

  @GetMapping("/accounts")
  public List<Accounts> getAllAccounts() {
    return transferService.getAllAccounts();
  }
}
