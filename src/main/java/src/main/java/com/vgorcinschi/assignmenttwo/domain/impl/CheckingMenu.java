/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import java.util.LinkedHashMap;
import static java.util.OptionalDouble.empty;
import static java.util.OptionalDouble.of;
import java.util.Scanner;
import static org.apache.commons.lang3.StringUtils.containsAny;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.DepositToAccountCommand;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.ReportOnAccount;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.WithdrawFromAccountCommand;
import static src.main.java.com.vgorcinschi.assignmenttwo.util.NumberFormatter.validateDoubleValue;
import src.main.java.com.vgorcinschi.assignmenttwo.util.StringValidator;

/**
 *
 * @author vgorcinschi
 */
public class CheckingMenu extends Menu {

    private CheckingAccount account;

    public CheckingMenu() {
        super("Checking Menu", new LinkedHashMap<>());
    }

    @Override
    public void execute(Menu menu, Scanner sc, java.util.OptionalDouble optional) {
        if (account == null) {
            System.out.println("Thank you for opening a Checking Account.");
            double startingBalance = validateDoubleValue(() -> "initial balance",
                    2, sc);
            double annualRate = validateDoubleValue(() -> "annual rate", 2, sc);
            account = new CheckingAccount(startingBalance, annualRate);
            options.put("A: Deposit", new DepositToAccountCommand(account));
            options.put("B: Withdraw", new WithdrawFromAccountCommand(account));
            options.put("C: Report", new ReportOnAccount(account));
            options.put("D: Return to Bank Menu", menu);
        }
        char choice = 0;
        //iterate until the user chooses to close the program
        while (choice != 'D') {
            System.out.println("Checking Menu");
            options.forEach((k, v) -> System.out.println(k));
            String input = StringValidator.stringValidator((s) -> {
                return (s.length() == 1 && containsAny(s.toUpperCase(), "ABCD"));
            }, () -> "Input must be exactly one character long. Allowed characters are: A, B, C, D", () -> "selection", sc);
            options.forEach((k, v) -> {
                if (k.substring(0, 1).equalsIgnoreCase(input.substring(0, 1))) {
                    if (containsAny(input.toUpperCase(), "AB")) {
                        double operationAmount = validateDoubleValue(() -> "amount", 2, sc);
                        v.execute(menu, sc, of(operationAmount));
                    } else {
                        v.execute(this, sc, empty());
                    }
                }
            });
            choice = input.charAt(0);
        }
    }

}
