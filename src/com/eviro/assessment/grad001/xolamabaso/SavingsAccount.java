package com.eviro.assessment.grad001.xolamabaso;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SavingsAccount extends Account{
    
    @Override
    public void witdraw(Long accountNum, BigDecimal amountToWithdraw) 
    {
        try
        {
            int res; 
            limit = new BigDecimal(1000);
            
            if (findAccount(accountNum))
            {
                getAccountBalance(accountNum);
                res = amountToWithdraw.compareTo(balance);
                if(res == 1) 
                { 
                    throw new WithdrawalAmountTooLargeException();
                }else
                {
                    check = balance.subtract(amountToWithdraw);
                    res = check.compareTo(limit);
                    if (res >=0)
                    {
                        balance = check;
                         System.out.println("New Balance: "  + balance);
                    }else
                    {
                        throw new WithdrawalAmountTooLargeException();
                    }
                }
                
            }
        }catch(WithdrawalAmountTooLargeException e)
        {
            System.out.println("Insuficient Funds");
        }
        catch(NullPointerException e)
        {
            System.out.println("Error. Null value:" + e);
        }
        catch(Exception e)
        {
             Logger.getLogger(CurrentAccount.class.getName()).log(Level.INFO, "ERROR", e);
  
        }
    }
 
    @Override
    public BigDecimal getAccountBalance(Long accountNum) {
       try{
        for (int i = 0; i < 3; i++)
        {
            for(int ii = 0; ii<3;ii++)
            {
                
                if (db.SavingsAccount[i][ii].equals(accountNum.toString()))
                {
                    balance = new BigDecimal(db.SavingsAccount[i][2]); 
                    System.out.println("Balance: " + balance);
                    return balance;
                }
            }
        }
        }catch(Exception ex)
        {
            Logger.getLogger(CurrentAccount.class.getName())
                    .log(Level.SEVERE, "SavingsAccount: getAccountBalance", ex);
 
        }
        return this.balance;
    }

    @Override
    public boolean findAccount(Long accountNum) throws AccountNotFoundException {
        boolean found = false;
        try {
            for (int i = 0; i < 3; i++)
            {
                for(int ii = 0; ii<3;ii++)
                { 
                    if (db.SavingsAccount[i][1].equals(accountNum.toString()))
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
            Logger.getLogger(CurrentAccount.class.getName()).log(Level.SEVERE, "SavingsAccount: accountFound()", ex);
        }
        return false;
    }

   
    
}
