/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import static java.util.OptionalDouble.empty;
import java.util.Scanner;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;

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
                    System.exit(1);
                });
    }

    @Override
    public void execute(src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu menu, java.util.Scanner sc, java.util.OptionalDouble optional) {
        char choice = 0;
        //iterate until the user chooses to close the program
        while (choice != 'C') {
            System.out.println("Bank Menu");
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
