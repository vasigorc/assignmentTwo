/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers;

import java.util.Scanner;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.BankAccount;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Command;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.impl.CheckingAccount;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.impl.SavingsAccount;

/**
 *
 * @author vgorcinschi
 */
public class WithdrawCommandExecutor implements Command{

    private final BankAccount account;

    public WithdrawCommandExecutor(BankAccount account) {
        if (account instanceof CheckingAccount) {
            this.account = (CheckingAccount) account;
        } else {
            this.account = (SavingsAccount) account;
        }
    }
    
    public void makeWithdraw(double withdraw){
        account.makeWithdraw(withdraw);
    }

    //we only need this to put this class in Menus's maps
    @Override
    public void execute(Menu menu, Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
