
package domain;

import java.util.List;

/**
 *
 * @author martin bøgh
 */
public class Kunde {
    private String name;
    private int phone;
    private List<Pizza> order;

    public Kunde(String name, int phone, List<Pizza> order) {
        this.name = name;
        this.phone = phone;
        this.order = order;
    }
    
   
    
    
}
