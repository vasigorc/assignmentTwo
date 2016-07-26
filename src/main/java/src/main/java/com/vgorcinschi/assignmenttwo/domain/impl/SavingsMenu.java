/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.impl;

import java.util.HashMap;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;

/**
 *
 * @author v_gorcin
 */
public class SavingsMenu extends Menu {
    private final SavingsAccount account = new SavingsAccount();

    public SavingsMenu() {
        super("Savings Menu", new HashMap<>());
        
    }

}
