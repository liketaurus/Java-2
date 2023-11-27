/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author alexa
 */
public abstract class Account {

    protected double balance;

    protected Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt) {
        if (amt > 0) {
            balance = balance + amt;
            return true;
        }
        return false;
    }

    public abstract boolean withdraw(double amt) throws OverDraftException;

}
