/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eviro.assessment.grad001.xolamabaso;

/**
 *
 * @author KaribaTwo
 */
public class WithdrawalAmountTooLargeException extends Exception {

    /**
     * Creates a new instance of <code>WithdrawalAmountTooLargeException</code>
     * without detail message.
     */
    public WithdrawalAmountTooLargeException() {
    }

    /**
     * Constructs an instance of <code>WithdrawalAmountTooLargeException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public WithdrawalAmountTooLargeException(String msg) {
        super(msg);
    }
}
