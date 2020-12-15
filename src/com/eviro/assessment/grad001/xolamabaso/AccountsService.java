package com.eviro.assessment.grad001.xolamabaso;

import java.math.BigDecimal;

public interface AccountsService {
   /**
    * This method withdraws the amount from the account balance.
    * @param accountNum Long. The account number.
    * @param amountToWithdraw BigDecimal. The amount to withdraw from account.
    * @throws WithdrawalAmountTooLargeException 
    * This exception is thrown if the withdraw amount is greater than:
    * SavingsAcount: must remain with a balance of 1000
    * CurrentAccount: must not be above the overdraft limit + current balance
    */
    public void witdraw(Long accountNum, BigDecimal amountToWithdraw)
            throws WithdrawalAmountTooLargeException;
}
