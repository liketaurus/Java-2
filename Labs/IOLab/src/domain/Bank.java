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
public class Bank {

    private static Bank myBank;

    private Bank() {
    }

    static {
        myBank = new Bank();
    }

    public static Bank getBank() {
        return myBank;
    }

    private ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer(String f, String l) {
        myBank.customers.add(new Customer(f, l));
    }

    public static Customer getCustomer(int index) {
        return myBank.customers.get(index);
    }

    public static int getNumberOfCustomers() {
        return myBank.customers.size();
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("Bank has "+getNumberOfCustomers()+" Customers:\n");
        for (Customer cust : customers) {
            temp.append((customers.indexOf(cust)+1)+". "+cust.toString());          
        }
        temp.append("\n");
        return temp.toString();
    }
}
