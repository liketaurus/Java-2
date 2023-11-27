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
public class SavingAccount extends Account {

    private double interestRate;

    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void accumulateInterest() {
        balance = balance + balance * interestRate;
    }

    @Override
    public boolean withdraw(double amt) throws OverDraftException{
        if (balance >= amt) {
            balance = balance - amt;
            return true;
        }
        throw new OverDraftException(amt-balance, "ERROR! Not sufficient funds!");
    }

}
