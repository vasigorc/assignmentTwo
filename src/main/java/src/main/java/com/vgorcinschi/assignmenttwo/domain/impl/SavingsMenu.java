/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import java.util.HashMap;
import java.util.Scanner;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers.WithdrawCommandExecutor;

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
            account = new SavingsAccount();
            options.put("A: Deposit", new WithdrawCommandExecutor(account));
        }
    }
}
