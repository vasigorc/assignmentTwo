/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.test.java.com.vgorcinschi.assignmenttwo.domain.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.impl.SavingsAccount;

/**
 *
 * @author v_gorcin
 */
public class SavingsAccountTests {

    private SavingsAccount account;

    public SavingsAccountTests() {
    }

    @Before
    public void setUp() {
        account = new SavingsAccount(50, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cannotWithdrawFromInactiveAcount() {
        //get below 25 first
        account.makeWithdraw(26);
        //this should not go through
        account.makeWithdraw(20);
        assertTrue(account.getMonthlyCurrentBalance() == 24);
    }

    @Test
    public void accountDisactivatedAndActivatedAgain() {
        account.makeWithdraw(26);
        assertFalse(account.isActive());
        account.makeDeposit(2);
        assertTrue(account.isActive());
    }

    @Test
    public void monthlyChargesForFourPlusTransactions() {
        for (int i = 0; i < 5; i++) {
            account.makeWithdraw(1);
        }
        System.out.println("\nmonthlyChargesForFourPlusTransactions:\n");
        System.out.println("Nr of withdrawals is " + account.getCountMonthlyWithdrawals());
        double intermediaryResult = account.getMonthlyCurrentBalance();
        double withoutAdditionalCharge = intermediaryResult + intermediaryResult * (account.getAnnualInterestRate() / 12);
        account.doMonthlyReport();
        assertNotEquals(account.getMonthlyCurrentBalance(), withoutAdditionalCharge);
    }

    @Test
    public void monthlyChargesForThreeLessTransactions() {
        for (int i = 0; i < 3; i++) {
            account.makeWithdraw(1);
        }
        System.out.println("\nmonthlyChargesForThreeLessTransactions:\n");
        System.out.println("Nr of withdrawals is " + account.getCountMonthlyWithdrawals());
        double intermediaryResult = account.getMonthlyCurrentBalance();
        double withoutAdditionalCharge = intermediaryResult + intermediaryResult * (account.getAnnualInterestRate() / 12);
        account.doMonthlyReport();
        assertTrue(account.getMonthlyCurrentBalance() == withoutAdditionalCharge);
    }
}
