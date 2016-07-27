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
public class SavingsAccount extends BankAccount {

    public SavingsAccount(double monthlyBalance, double annualInterestRate) {
        super(monthlyBalance, annualInterestRate);
    }
    
    @Override
    public void doMonthlyReport() {
        //savings account service charges:
        if (this.countMonthlyWithdrawals > 4) {
            this.monthlyServiceCharge += this.countMonthlyWithdrawals - 4;
        }
        super.doMonthlyReport(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeWithdraw(double withdraw) {
        if (this.active == true) {
            super.makeWithdraw(withdraw); //To change body of generated methods, choose Tools | Templates.
        } else {
            System.out.println("Account " + this.getAccountNumber() + " is inactive. Please"
                    + " check that you have sufficient funds to perform this operation.");
        }
    }

    @Override
    public void makeDeposit(double deposit) {
        super.makeDeposit(deposit); //To change body of generated methods, choose Tools | Templates.
    }

}
