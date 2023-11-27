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
public class CheckingAccountTest {

    public CheckingAccountTest() {
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
     * Test of withdraw method, of class CheckingAccount.
     */
    @Test
    public void testWithdraw() throws OverDraftException {
        System.out.println("Withdraw");
        double amt = 2000;
        CheckingAccount instance = new CheckingAccount(2000, 1000);
        boolean expResult = true;
        boolean result = instance.withdraw(amt);
        assertEquals(expResult, result);
    }

    @Test(expected = OverDraftException.class)
    public void testWithdrawException() throws OverDraftException {
        System.out.println("Withdraw (exception)");
        double amt = 5500;
        CheckingAccount instance = new CheckingAccount(4000, 1000);
        boolean expResult = true;
        boolean result = instance.withdraw(amt);
    }

}
