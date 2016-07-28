/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.assignmenttwo.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author v_gorcin
 */
public abstract class Menu implements Command {
    protected String name;
    protected Map<String, Command> options;

    public Menu(String name, Map<String, Command> options) {
        this.name = name;
        this.options = options;
    }

    public Menu() {
        this("Empty Menu", new LinkedHashMap<>());
    }    
    
    @Override
    public void execute(src.main.java.com.vgorcinschi.assignmenttwo.domain.Menu menu, java.util.Scanner sc, java.util.OptionalDouble optional) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Command> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Command> options) {
        this.options = options;
    }
}
