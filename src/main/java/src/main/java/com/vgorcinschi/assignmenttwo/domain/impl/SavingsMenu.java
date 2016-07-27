/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import java.util.HashMap;
import static java.util.OptionalDouble.empty;
import java.util.Scanner;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.DepositToAccountCommand;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.ReportOnAccount;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.WithdrawFromAccountCommand;
import static src.main.java.com.vgorcinschi.assignmenttwo.util.NumberFormatter.validateDoubleValue;

/**
 *
 * @author v_gorcin
 */
public class SavingsMenu extends Menu {

    private SavingsAccount account = null;

    public SavingsMenu() {
        super("Savings Menu", new HashMap<>());
    }

    @Override
    public void execute(Menu menu, Scanner sc, java.util.OptionalDouble optional) {
        if (account == null) {
            //collect starting balance and annual rate
            System.out.println("Thank you for opening a Savings Account.");
            double startingBalance = validateDoubleValue(() -> "initial balance",
                    2, sc);
            double annualRate = validateDoubleValue(() -> "annual rate", 2, sc);
            account = new SavingsAccount(startingBalance, annualRate);
            options.put("A: Deposit", new DepositToAccountCommand(account));
            options.put("B: Withdraw", new WithdrawFromAccountCommand(account));
            options.put("C: Report", new ReportOnAccount(account));
            options.put("D: Return to Bank Menu", menu);
        }
        char choice = 0;
        //iterate until the user chooses to close the program
        while (choice != 'D') {
            System.out.println("Savings Menu");
            options.forEach((k, v) -> System.out.println(k));
            String input = sc.nextLine();
            options.forEach((k, v) -> {
                if (k.substring(0, 1).equalsIgnoreCase(input.substring(0, 1))) {
                    v.execute(this, sc, empty());
                }
            });
        }
    }
}
