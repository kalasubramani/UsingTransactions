package com.example.usingtransactions.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usingtransactions.Model.Accounts;
import com.example.usingtransactions.Repository.AccountRepository;

@Service
@Transactional 
public class TransferService {
  
  private final AccountRepository accountRepository;
 
  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }



                                     
  public void transferMoney(long idSender, 
                            long idReceiver, 
                            BigDecimal amount) {
    Accounts sender =                                 
      accountRepository.findAccountById(idSender);   
    Accounts receiver =                               
      accountRepository.findAccountById(idReceiver); 
 
    BigDecimal senderNewAmount =                     
      sender.getAmount().subtract(amount);           
    BigDecimal receiverNewAmount =                   
      receiver.getAmount().add(amount);   
      accountRepository.changeAmount(idSender, senderNewAmount);       
 
    accountRepository.changeAmount(idReceiver, receiverNewAmount);   

    throw new RuntimeException("Oh no! Something went wrong!");   
  }

  public List<Accounts> getAllAccounts() {
    return accountRepository.findAllAccounts();
  }

}