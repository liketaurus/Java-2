/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionslab;

import domain.*;

/**
 *
 * @author alexa
 */
public class CollectionsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Bank myBank = Bank.getBank();
        Bank.addCustomer("John", "Doe");
        Bank.addCustomer("Jane", "Doe");

        SavingAccount sa1 = new SavingAccount(1000, 0.05);
        CheckingAccount ca1 = new CheckingAccount(1000, 1000);

        Customer firstCustomer = Bank.getCustomer(0);
        firstCustomer.addAccount(sa1);
        firstCustomer.addAccount(ca1);

        CheckingAccount ca2 = new CheckingAccount(2000, 1000);

        Customer secondCustomer = Bank.getCustomer(1);
        secondCustomer.addAccount(ca2);
        
        System.out.println(myBank);
        

    }

}
