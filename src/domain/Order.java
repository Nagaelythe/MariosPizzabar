/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class Order {
    Pizza pizza;
    ArrayList<Pizza> pizzas = new ArrayList<>();
    public final Customer customer;
    private boolean afhentet = false;
        
    public Order(Pizza pizza,Customer customer){
        this.pizza = pizza;
        this.customer = customer;
        this.customer.addPizzaToCustomer(pizza);
    }
    // Overload Constructor to handle orders of more than one pizza.
    public Order(ArrayList<Pizza> pizzas,Customer customer){
        this.customer = customer;
        this.pizzas = pizzas;         
    }
    
    public void afhented(){
        this.afhentet = true;
    }
    
    public boolean isDone(){
        return afhentet;
    }
    
    
}
