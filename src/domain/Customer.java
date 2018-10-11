package domain;

/*
* Customer samler navn og telefonnummer sammen med en samlet list af ordrer fra
* denne kunde.
* Man kan eksternt add'e pizza-typer til denne liste 
*/

import datasource.Archive;
import java.util.ArrayList;

/**
 *
 * @author martin bøgh
 */
public class Customer {

    private String name;
    private int phone;
    private ArrayList<Pizza> customerOrders = new ArrayList<>();

    public Customer(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public void addPizzaToCustomer(Pizza pizza) {
        customerOrders.add(pizza);
    }

    public void addPizzasToCustomer(ArrayList<Pizza> Pizzas){
        for(Pizza p: Pizzas){
            customerOrders.add(p);
        }
    }
    
    public void showOrders() {
        Archive arch = new Archive();
        System.out.println(name + "'s tidligere ordrer:");
        for (Order order : arch.getOrder(this)) {
            System.out.println(order);
        }
    }
    
        @Override
        public String toString() {
        return "Kunde{" + "name=" + name + ", phone=" + phone  + '}';
        }

    }
