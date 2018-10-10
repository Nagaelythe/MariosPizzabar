
package domain;

import java.util.ArrayList;

/**
 *
 * @author martin bøgh
 */
public class Kunde {
    private String name;
    private int phone;
    private ArrayList<Pizza> orders = new ArrayList<>();
    private Pizza pizza;

    public Kunde(String name, int phone, Pizza pizza) {
        this.name = name;
        this.phone = phone;
        this.pizza = pizza;
    }
    

    public void addCustomer(){
        orders.add(pizza);
    }
}
