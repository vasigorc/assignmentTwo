/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import java.util.HashMap;
import java.util.Scanner;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;

/**
 *
 * @author vgorcinschi
 */
public class CheckingMenu extends Menu {

    private CheckingAccount account;

    public CheckingMenu() {
        super("Checking Menu", new HashMap<>());
    }

    @Override
    public void execute(Menu menu, Scanner sc) {
        if (account == null) {
            account = new CheckingAccount();
        }
    }

}
