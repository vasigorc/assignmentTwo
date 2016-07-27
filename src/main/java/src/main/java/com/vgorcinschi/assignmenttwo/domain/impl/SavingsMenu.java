/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import java.util.HashMap;
import java.util.Scanner;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;
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
    public void execute(Menu menu, Scanner sc) {
        if (account == null) {            
            //collect starting balance and annual rate
            System.out.println("Thank you for opening a Savings Account.");
            double startingBalance = validateDoubleValue(()->"initial balance",
                    2, sc);
            double annualRate = validateDoubleValue(()->"annual rate", 2, sc);
            account = new SavingsAccount(startingBalance, annualRate);            
        }
        
    }
}
