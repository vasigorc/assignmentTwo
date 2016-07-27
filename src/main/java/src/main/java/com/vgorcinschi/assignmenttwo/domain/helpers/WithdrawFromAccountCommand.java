/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain.helpers;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import src.main.java.com.vgorcinschi.assignmenttwo.domain.*;

/**
 *
 * @author vgorcinschi
 */
public class WithdrawFromAccountCommand extends SimpleBankOperation {
    
    private final Logger log = LogManager.getLogger();

    public WithdrawFromAccountCommand(BankAccount account) {
        super(account);
    }

    @Override
    public void execute(Menu menu, Scanner sc, OptionalDouble optional) {
        if (optional.isPresent()) {
            account.makeWithdraw(optional.getAsDouble());
        }else{
            log.warn("An attempt to withdraw money with no amount occured on account "
                    + "number "+account.getAccountNumber());
        }
    }

}
