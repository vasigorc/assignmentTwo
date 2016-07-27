/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain;

import java.util.OptionalDouble;
import java.util.Scanner;

/**
 *
 * @author v_gorcin
 */
public interface Command {

    public void execute(Menu menu, Scanner sc, OptionalDouble optional);
}
