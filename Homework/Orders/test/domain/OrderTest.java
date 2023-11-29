/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexa
 */
public class OrderTest {

    public OrderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Order.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Order.Item item = new Order.Item(" ", 0, 1);
        Order instance = new Order();
        int expectedResult = 1;

        instance.addItem(item);
        int result = instance.getNumberOfItems();

        assertEquals(expectedResult, result);

    }

    /**
     * Test of removeItem method, of class Order.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Order.Item item1 = new Order.Item(" ", 0, 1);
        Order.Item item2 = new Order.Item(" ", 0, 1);
        Order instance = new Order();
        instance.addItem(item1);
        instance.addItem(item2);
        int expectedResult = 1;

        instance.removeItem(item1);
        int result = instance.getNumberOfItems();

        assertEquals(expectedResult, result);
    }

    /**
     * Test of calculateTotal method, of class Order.
     */
    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        Order.Item item1 = new Order.Item(" ", 5.0, 1);
        Order.Item item2 = new Order.Item(" ", 5.0, 1);
        Order instance = new Order();
        instance.addItem(item1);
        instance.addItem(item2);
        double expResult = 10.0;

        double result = instance.calculateTotal();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of placeOrder method, of class Order.
     */
    @Test(expected = EmptyOrderException.class)
    public void testPlaceOrder() throws EmptyOrderException {
        System.out.println("placeOrder");
        Order instance = new Order();
        instance.placeOrder();
    }

}
