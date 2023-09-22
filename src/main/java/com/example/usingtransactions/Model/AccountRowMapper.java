package com.example.usingtransactions.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper  implements RowMapper<Accounts>{
  
  @Override
  public Accounts mapRow(ResultSet resultSet, int i)    
    throws SQLException {
    Accounts a = new Accounts();                         
    a.setId(resultSet.getInt("id"));                   
    a.setName(resultSet.getString("name"));            
    a.setAmount(resultSet.getBigDecimal("amount"));    
    return a;                                          
  }

}
