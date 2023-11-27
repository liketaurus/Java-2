/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

import domain.Account;
import domain.CheckingAccount;
import domain.OverDraftException;
import domain.SavingAccount;

/**
 *
 * @author alexa
 */
public class TestAccounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SavingAccount sa = new SavingAccount(1000, 0.05);
        CheckingAccount ca = new CheckingAccount(2000, 1000);

        System.out.println("You have a new checking account with $2000 amount and $1000 overdraft!\n");
        System.out.println("Attempt to deposit $2000");
        System.out.println(ca.deposit(2000) ? "Success!" : "Failed...");
        System.out.println("Account balance: $" + ca.getBalance());
        System.out.println();

        System.out.println("Attempt to withdraw $5500");
        try {
            ca.withdraw(5500);
        } catch (OverDraftException oa) {
            System.out.println("Not enough money! Deficit is: $" + oa.getDeficit());
        }
        System.out.println("Account balance: $" + ca.getBalance());
        System.out.println();

        System.out.println("You have a new savings account with $1000 amount and 5% interest rate!\n");
        System.out.println("Attempt to deposit $2000");
        System.out.println(sa.deposit(2000) ? "Success!" : "Failed...");
        System.out.println("Account balance: $" + sa.getBalance());
        System.out.println("Attempt to accumulate interest");
        sa.accumulateInterest();
        System.out.println("Account balance: $" + sa.getBalance());
        System.out.println();

        System.out.println("Attempt to withdraw $5500");
        try {
            sa.withdraw(5500);
        } catch (OverDraftException oa) {
            System.out.println("Not enough money! Deficit is: $" + oa.getDeficit());
        }
        System.out.println("Account balance: $" + sa.getBalance());

    }

}
