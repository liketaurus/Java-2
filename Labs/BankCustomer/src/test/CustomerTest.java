
package test;

import domain.Customer;

public class CustomerTest {
    
    public static void main(String[] args) {
        
        Customer firstCustomer = new Customer();
        System.out.println(firstCustomer);
        
//        Customer secondCustomer = new Customer(-5,true,4000);
//        System.out.println(secondCustomer);
                
        Customer thirdCustomer = new Customer(5,-4000);
        System.out.println(thirdCustomer);
        
        thirdCustomer.setTotal(1000);
        System.out.println(thirdCustomer);
        
        thirdCustomer.setTotal(-5);
        System.out.println(thirdCustomer);
        
    
    }
}
