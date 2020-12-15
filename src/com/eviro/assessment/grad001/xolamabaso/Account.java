/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eviro.assessment.grad001.xolamabaso;

import java.math.BigDecimal;

/**
 *
 * @author Xola Mabaso
 */
public abstract class Account implements AccountsService {

    SystemDB db = SystemDB.getInstance();
    
    BigDecimal balance, check, limit;
    Long accountNumber;

   /**
   * This method locates the current balance of an account. It accepts 
   * the account number as a parameter.
   * @param accountNum Long. The account number  
   * @return BigDecimal This returns the current balance of the account. 
   */
    public abstract BigDecimal getAccountBalance(Long accountNum);
    
    /**
   * This method is for searching and locating the account number.
   * @param accountNum Long. The account number  
   * @throws com.eviro.assessment.grad001.xolamabaso.AccountNotFoundException  
   * If the account does not exist then AccountNotFoundException will thrown.
  * @return Boolean This returns true if the account exists. 
   */
    public abstract boolean findAccount(Long accountNum)throws AccountNotFoundException;
}
