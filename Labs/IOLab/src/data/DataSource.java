/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Bank;
import domain.CheckingAccount;
import domain.Customer;
import domain.SavingAccount;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class DataSource {

    private File dataFile;

    public DataSource(String dataFilePath) {
        this.dataFile = new File(dataFilePath);
    }

    public void loadData() throws IOException {
        Scanner input = new Scanner(dataFile);

        Customer customer;
        int numOfCustomers = input.nextInt();
        for (int idx = 0; idx < numOfCustomers; idx++) {
            String firstName = input.next();
            String lastName = input.next();
            Bank.addCustomer(firstName, lastName);
            customer=Bank.getCustomer(idx);
            
            int numOfAccounts = input.nextInt();
            while (numOfAccounts-- >0){
                char accountType = input.next().charAt(0);
                switch (accountType){
                    case 'S':{
                        float balance = input.nextFloat();
                        float interestRate = input.nextFloat();
                        customer.addAccount(new SavingAccount(balance,interestRate));
                        break;
                    }
                    case 'C':{
                        float balance = input.nextFloat();
                        float overdraft = input.nextFloat();
                        customer.addAccount(new CheckingAccount(balance,overdraft));
                        break;
                    }
                    default:
                        throw new IOException("ERROR! Unknown account type (customer #"+idx+")!");                  
                }
            }
        }

    }

}
