
package domain;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author martin bøgh
 */
public class Customer {
    private String name;
    private int phone;
    private ArrayList<Pizza> orders = new ArrayList<>();
    private Pizza pizza;

    public Customer(String name, int phone, Pizza pizza) {
        this.name = name;
        this.phone = phone;
        this.pizza = pizza;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public ArrayList<Pizza> getOrders() {
        return orders;
    }
    

    public void addPizzaToCustomer(){
        orders.add(pizza);
    }
    
    public void showOrders(){
        System.out.println(name +"'s tidligere ordrer:");
        for (Pizza order : orders) {
            System.out.println(order);
        }  
    }
   
    public 
    
    public void saveToFile(){
        //Hent fil-indhold
        
        //Læg nyt indhold til
        
        //Gem indhold
        
        
    }
    
    
    
    @Override
    public String toString() {
        return "Kunde{" + "name=" + name + ", phone=" + phone + ", orders=" + orders + ", pizza=" + pizza + '}';
    }

}
