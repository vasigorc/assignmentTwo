/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import static java.util.OptionalDouble.empty;
import java.util.Scanner;
import static org.apache.commons.lang3.StringUtils.containsAny;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;
import src.main.java.com.vgorcinschi.assignmenttwo.util.StringValidator;

/**
 *
 * @author v_gorcin
 */
public class BankMenu extends Menu {

    private final Scanner sc = new Scanner(System.in);

    public BankMenu() {
        this.name = "Menu";
        this.options.put("A: Savings", new SavingsMenu());
        this.options.put("B: Checking", new CheckingMenu());
        this.options.put("C: Exit",
                (src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu menu,
                        java.util.Scanner sc, java.util.OptionalDouble optional) -> {
                    System.out.println("Thank you, come back!");
                    System.exit(0);
                });
    }

    @Override
    public void execute(src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu menu, java.util.Scanner sc, java.util.OptionalDouble optional) {
        char choice = 0;
        //iterate until the user chooses to close the program
        while (choice != 'C') {
            System.out.println("Bank Menu");
            options.forEach((k, v) -> System.out.println(k));
            String input = StringValidator.stringValidator((s) -> {
                return (s.length() == 1 && containsAny(s.toUpperCase(), "ABC"));
            }, () -> "Input must be exactly one character long. Allowed characters are: A, B, C", () -> "selection", sc);
            options.forEach((k, v) -> {
                if (k.substring(0, 1).equalsIgnoreCase(input.substring(0, 1))) {
                    v.execute(this, sc, empty());
                }
            });
            choice = input.charAt(0);
        }
    }

    public void run() {
        //start the flywheel
    System.out.println("Welcome to the Bank Menu!");
        execute(this, sc, empty());
    }

}
