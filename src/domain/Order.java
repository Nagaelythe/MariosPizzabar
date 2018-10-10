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
    private Kunde kunde;
    private boolean afhentet = false;

    
    public Order(Pizza pizza, Kunde kunde){
        this.pizza = pizza;
        this.kunde = kunde;
        this.kunde.addPizzaToCustomer(pizza);
    }
    public void afhented(){
        this.afhentet = true;
    }
    
    public boolean isDone(){
        return afhentet;
    }
    
    
}
