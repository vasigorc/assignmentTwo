/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers;

import java.util.*;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.*;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.impl.*;

/**
 *
 * @author vgorcinschi
 */
public abstract class SimpleBankOperation implements Command{
    protected final BankAccount account;
    
    public SimpleBankOperation(BankAccount account) {
        if (account instanceof SavingsAccount) {
            this.account = (SavingsAccount) account;
        } else {
            this.account = (CheckingAccount) account;
        }
    }

    @Override
    public abstract void execute(Menu menu, Scanner sc, OptionalDouble optional);
}
