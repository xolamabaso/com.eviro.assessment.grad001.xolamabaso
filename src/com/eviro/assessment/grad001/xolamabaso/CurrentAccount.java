/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eviro.assessment.grad001.xolamabaso;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xola Mabaso
 */
public class CurrentAccount extends Account{
    
    BigDecimal overdraft; 
    
    @Override
    public BigDecimal getAccountBalance(Long accountNum) {
       try{
        for (int i = 0; i < 3; i++)
        {
            for(int ii = 0; ii<4;ii++)
            {
                
                if (db.CurrentAccount[i][ii].equals(accountNum.toString()))
                {
                    balance = new BigDecimal(db.CurrentAccount[i][2]); 
                    System.out.println("Balance: " + balance);
                    return balance;
                }
            }
        }
        }catch(Exception ex)
        {
            Logger.getLogger(CurrentAccount.class.getName())
                    .log(Level.SEVERE, "CurrentAccounut: getAccountBalance", ex);
        }
        return this.balance;
    }

    @Override
       public void witdraw(Long accountNum, BigDecimal amountToWithdraw) 
               throws WithdrawalAmountTooLargeException, NullPointerException
    {
        try
        {
            int res; 
            
            if (findAccount(accountNum))
            {
                getAccountBalance(accountNum);
                overdraft = new BigDecimal(getOverdraft(accountNum).longValue());
                
                this.limit = balance.add(overdraft);
                
                res = amountToWithdraw.compareTo(limit);
              
                if(res >0) 
                { 
                    throw new WithdrawalAmountTooLargeException();
                }else
                {
                    check = balance.subtract(amountToWithdraw);
                    res = check.compareTo(limit);
                    if (res < 0)
                    {
                        balance = check;
                         System.out.println("New Balance: "  + balance);
                    }else
                    {
                        throw new WithdrawalAmountTooLargeException();
                    }
                }
                
            }
        }catch(WithdrawalAmountTooLargeException ex)
        {
            System.out.println("Insuficient Funds");
        }
        catch(NullPointerException ex)
        {
               Logger.getLogger(CurrentAccount.class.getName()).log(Level.INFO, "CurrentAccount: Null Value", ex);
        }
        catch(Exception ex)
        {
            Logger.getLogger(CurrentAccount.class.getName()).log(Level.SEVERE, "CurrentAccount: withdraw()", ex);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
        public boolean findAccount(Long accountNum) {
        boolean found = false;
        try {
            for (int i = 0; i < 3; i++)
            {
                for(int ii = 0; ii<4;ii++)
                { 
                    if (db.CurrentAccount[i][1].equals(accountNum.toString()))
                    {
                        System.out.println("Account Found: " + accountNum);
                        found = true;
                        return found;
                    } 
                }
            }
            if (!found)
                throw new AccountNotFoundException();
         
        } catch (AccountNotFoundException ex) {
           System.out.println("Account Not Found: " + accountNum);        
        }
        catch(Exception ex){
            Logger.getLogger(CurrentAccount.class.getName()).log(Level.SEVERE, "CurrentAccount: accountFound()", ex);
        }
        return false;
    }
public BigDecimal getOverdraft(Long accountNum) {
        try{
            for (int i = 0; i < 3; i++)
            {
                for(int ii = 0; ii<4;ii++)
                { 
                    if (db.CurrentAccount[i][1].equals(accountNum.toString()))
                    {
                        overdraft = new BigDecimal(db.CurrentAccount[i][3]);
                        System.out.println("Overdraft: " + overdraft);
                        return overdraft;
                    } 
                }
            }
        }catch(Exception ex)
        {
            Logger.getLogger(CurrentAccount.class.getName()).log(Level.SEVERE, "CurrentAcount: GetOverDraft()", ex);
        }
        return overdraft;
    }
  
}
