package domain;

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

    public void showOrders() {
        System.out.println(name + "'s tidligere ordrer:");
        for (Pizza order : customerOrders) {
            System.out.println(order);
        }
    }

    public void saveToFile() {
        //Hent fil-indhold
        Archive arch = new Archive();
//        arch.

        //Læg nyt indhold til
        //Gem indhold
    }

    @Override
    public String toString() {
        return "Kunde{" + "name=" + name + ", phone=" + phone + ", orders=" + customerOrders + '}';
    }

}
