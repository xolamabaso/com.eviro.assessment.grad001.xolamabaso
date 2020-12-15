package com.eviro.assessment.grad001.xolamabaso;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xola Mabaso
 */
public class Main {

     public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
       {
            try {
                 SystemDB db = SystemDB.getInstance();
                 SavingsAccount sAcc = new SavingsAccount();
                 CurrentAccount cAcc = new CurrentAccount();
                 
                 db.SavingsAccount = new String [][]  {
                     {"101","1","5999"},
                     {"103","3","23000"},
                     {"105","5","3999"}
                 };
                 db.CurrentAccount = new String [][]  {
                     {"102","2","-1000","10000"},
                     {"104","4","1000","5000"},
                     {"106","6","35000","60000"}
                 };
                 
                 
                 sAcc.witdraw(5L, BigDecimal.valueOf(600));
                 cAcc.witdraw(2L, BigDecimal.valueOf(12000));
                

             } catch (WithdrawalAmountTooLargeException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             } catch (NullPointerException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}
    
}
