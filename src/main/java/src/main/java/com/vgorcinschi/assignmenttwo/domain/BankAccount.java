/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain;

import java.util.concurrent.atomic.AtomicInteger;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.impl.SavingsAccount;

/**
 *
 * @author vgorcinschi
 */
public abstract class BankAccount {

    protected double monthlyStartingBalance, monthlyCurrentBalance, monthlyTotalDeposits,
            monthlyTotalWithdrawals, monthlyServiceCharge;
    protected double annualInterestRate;
    protected boolean active = false;
    protected int countMonthlyDeposits, countMonthlyWithdrawals, accountNumber;
    private static AtomicInteger number = new AtomicInteger(1);

    public BankAccount(double monthlyBalance, double annualInterestRate) {
        accountNumber = number.getAndIncrement();
        if (monthlyBalance < 0) {
            this.monthlyStartingBalance = 0;
        } else {
            this.monthlyStartingBalance = monthlyBalance;
        }
        this.monthlyCurrentBalance = this.monthlyStartingBalance;
        if (annualInterestRate < 0) {
            this.annualInterestRate = 5;
        } else {
            this.annualInterestRate = annualInterestRate;
        }
        updateStatus();
    }

    public BankAccount() {
        this(0, 5);
    }

    public void updateStatus() {
        if (this instanceof SavingsAccount) {
            this.active = this.monthlyStartingBalance >= 25;
        } else {
            this.active = this.monthlyStartingBalance >= 5;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getMonthlyStartingBalance() {
        return monthlyStartingBalance;
    }

    public void setMonthlyStartingBalance(double monthlyStartingBalance) {
        this.monthlyStartingBalance = monthlyStartingBalance;
    }

    public double getMonthlyCurrentBalance() {
        return monthlyCurrentBalance;
    }

    public void setMonthlyCurrentBalance(double monthlyCurrentBalance) {
        this.monthlyCurrentBalance = monthlyCurrentBalance;
    }

    public double getMonthlyTotalDeposits() {
        return monthlyTotalDeposits;
    }

    public void setMonthlyTotalDeposits(double monthlyTotalDeposits) {
        this.monthlyTotalDeposits = monthlyTotalDeposits;
    }

    public double getMonthlyTotalWithdrawals() {
        return monthlyTotalWithdrawals;
    }

    public void setMonthlyTotalWithdrawals(double monthlyTotalWithdrawals) {
        this.monthlyTotalWithdrawals = monthlyTotalWithdrawals;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getCountMonthlyDeposits() {
        return countMonthlyDeposits;
    }

    public void setCountMonthlyDeposits(int countMonthlyDeposits) {
        this.countMonthlyDeposits = countMonthlyDeposits;
    }

    public int getCountMonthlyWithdrawals() {
        return countMonthlyWithdrawals;
    }

    public void setCountMonthlyWithdrawals(int countMonthlyWithdrawals) {
        this.countMonthlyWithdrawals = countMonthlyWithdrawals;
    }

    public double getMonthlyServiceCharge() {
        return monthlyServiceCharge;
    }

    public void setMonthlyServiceCharge(double monthlyServiceCharge) {
        this.monthlyServiceCharge = monthlyServiceCharge;
    }

    public void makeDeposit(double deposit) {
        if (deposit > 0) {
            monthlyTotalDeposits += deposit;
            countMonthlyDeposits++;
            monthlyCurrentBalance += deposit;
            updateStatus();
        } else {
            System.out.println("Can't deposit an amount equal or less then zero."
                    + " Transaction rolled back.");
        }
    }

    public void makeWithdraw(double withdraw) {
        if (withdraw < monthlyCurrentBalance) {
            monthlyTotalWithdrawals += withdraw;
            countMonthlyDeposits++;
            monthlyCurrentBalance -= withdraw;
            updateStatus();
        } else {
            System.out.println("Insufficient funds. You don't have enough money."
                    + " Transaction rolled back.");
        }
    }

    public void calculateInterest() {
        double monthlyInterest = monthlyCurrentBalance * (annualInterestRate / 12);
        monthlyCurrentBalance += monthlyInterest;
    }

    public void doMonthlyReport() {
        monthlyCurrentBalance -= monthlyServiceCharge;
        calculateInterest();
        updateStatus();
        countMonthlyDeposits = 0;
        countMonthlyWithdrawals = 0;
        monthlyServiceCharge = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
