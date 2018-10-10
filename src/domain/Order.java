/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Martin Wulff
 */
public class Order {
    private Pizza pizza;
    private Customer customer;
    private boolean afhentet = false;

    
    public Order(Pizza pizza,Customer customer){
        this.pizza = pizza;
        this.customer = customer;
        this.customer.addPizzaToCustomer(pizza);
    }
    public void afhented(){
        this.afhentet = true;
    }
    
    public boolean isDone(){
        return afhentet;
    }
    
    
}
