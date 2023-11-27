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
public class CheckingAccount extends Account {

    private double overdraftAmount;

    public CheckingAccount(double balance, double overdraftAmount) {
        super(balance);
        this.overdraftAmount = overdraftAmount;
    }

    public CheckingAccount(double balance) {
        this(balance, 0);
    }

    @Override
    public boolean withdraw(double amt) throws OverDraftException {
        if (balance + overdraftAmount > amt) {
            balance = balance - amt;
            return true;
        }
        throw new OverDraftException(amt - balance - overdraftAmount, "ERROR! Not sufficient funds!");
    }

}
