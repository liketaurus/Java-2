/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orders;

import domain.EmptyOrderException;
import domain.Order;

/**
 *
 * @author alexa
 */
public class OrdersTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyOrderException {
        // TODO code application logic here
        Order.Item item1 = new Order.Item("SSD 2Tb SAMSUNG", 2250.00, 1);
        Order.Item item2 = new Order.Item("Type-C cable", 780.00, 2);

        Order order = new Order();
        order.addItem(item1);
        order.addItem(item2);

        System.out.println(order);

        
        System.out.println("\nПробуємо оформити замовлення...");
        
        try {
            order.placeOrder();
        } catch (EmptyOrderException ex) {
            System.err.println(ex);
        }

        System.out.println(order);
        
        System.out.println("\nСтворюємо ще одне замовлення і пробуємо його оформити...");

        Order order2 = new Order();
        
        System.out.println(order2);
        
        try {
            order2.placeOrder();
        } catch (EmptyOrderException ex) {
            System.out.println("\nПОМИЛКА!"+ex.getMessage());
        }
    }

}
