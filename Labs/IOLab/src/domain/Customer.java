/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author alexa
 */
public class Customer {

    private final String firstName;
    private final String lastName;

    private ArrayList<Account> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("Customer: \n\t" + firstName + "\n\t" + lastName);
        temp.append("\nAccounts("+getNumberOfAccounts()+"):");
        for (Account acc : accounts) {
            temp.append("\n\t"+(accounts.indexOf(acc)+1)+". "+acc.toString());          
        }
        temp.append("\n");
        return temp.toString();
    }

}
