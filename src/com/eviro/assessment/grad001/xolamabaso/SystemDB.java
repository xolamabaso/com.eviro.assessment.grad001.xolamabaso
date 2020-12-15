package com.eviro.assessment.grad001.xolamabaso;

public class SystemDB 
{
    
    private static SystemDB INSTANCE;
    
    String [][] SavingsAccount;
    String [][]CurrentAccount;
    private SystemDB() 
    {
    
    }
    
    public static SystemDB getInstance() 
    {
        if (INSTANCE == null) 
		{ 
			INSTANCE = new SystemDB(); 
		} 
		return INSTANCE; 
    }
}