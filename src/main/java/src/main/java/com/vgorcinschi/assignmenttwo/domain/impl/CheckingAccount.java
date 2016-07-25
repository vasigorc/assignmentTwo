/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import src.main.java.com.vgorcinschi.assignmenttwo.domain.BankAccount;

/**
 *
 * @author vgorcinschi
 */
public class CheckingAccount extends BankAccount {

    @Override
    public void doMonthlyReport() {
        monthlyServiceCharge += 5 + (countMonthlyWithdrawals * 0.1);
        super.doMonthlyReport(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeWithdraw(double withdraw) {
        if (withdraw < monthlyCurrentBalance) {
            //is this service charge a one time or it is appended to the monthly?
            monthlyCurrentBalance -= 15;
            super.makeWithdraw(withdraw); //To change body of generated methods, choose Tools | Templates.
            System.out.println("A penalty of 15$ has been applied to your account "
                    + "for the account overdraw balance attempt.");
        } else {
            super.makeWithdraw(withdraw);
        }

    }

}
