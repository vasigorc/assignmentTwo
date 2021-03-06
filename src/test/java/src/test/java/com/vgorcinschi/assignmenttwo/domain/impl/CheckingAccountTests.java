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
import src.main.java.com.vgorcinschi.assignmenttwo.domain.impl.CheckingAccount;

/**
 *
 * @author v_gorcin
 */
public class CheckingAccountTests {

    private CheckingAccount account;

    public CheckingAccountTests() {
    }

    @Before
    public void setUp() {
         account = new CheckingAccount(50, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cannotOverdrawAcount() {
        System.out.println("\ncannotOverdrawAcount\n");
        //attemtping to withdraw more then we have
        account.makeWithdraw(60);
        assertTrue("The result ought to be 50$-15$ penalty, i.e.: 35$", 35 == account.getMonthlyCurrentBalance());
    }
    
    @Test
    public void appendableMonthlyCharges(){
        //we only withdraw 1$. So the onthly service fee has to be 5.10$
        account.makeWithdraw(1);
        System.out.println("\nappendableMonthlyCharges:\n");
        //deduct the service fee
        double intermediaryResult = account.getMonthlyCurrentBalance()-5.10;
        //imitate manually the interest calculation
        double withoutAdditionalCharge = intermediaryResult + intermediaryResult * (account.getAnnualInterestRate() / 12);
        account.doMonthlyReport();
        //compare the two results
        assertTrue(account.getMonthlyCurrentBalance() == withoutAdditionalCharge);
    }
}
