package com.example.usingtransactions.Model;

import java.math.BigDecimal;

public class Accounts {
  private long id;
  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  private String name;
  private BigDecimal amount;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  // Omitted getters and setters
}
