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
public class Order implements java.io.Serializable {
//    Pizza pizza;

    ArrayList<Pizza> pizzas = new ArrayList<>();
    public final Customer customer;
    private boolean afhentet = false;
    public final int price;

    public Order(Pizza pizza, Customer customer) {
        this.pizzas.add(pizza);
        this.customer = customer;
        this.customer.addPizzaToCustomer(pizza);
        int sum = 0;
        for (Pizza p : pizzas) {
            sum += p.getPrice();
        }
        this.price = sum;
    }

    // Overload Constructor to handle orders of more than one pizza.
    public Order(ArrayList<Pizza> pizzas, Customer customer) {
        this.customer = customer;
        this.pizzas = pizzas;
        this.customer.addPizzasToCustomer(pizzas);
        int sum = 0;
        for (Pizza p : pizzas) {
            sum += p.getPrice();
        }
        this.price = sum;
    }

    public void afhented() {
        this.afhentet = true;
    }

    public boolean isDone() {
        return afhentet;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public String toString() {
        return "Order{" + "pizzas=" + pizzas + ", customer=" + customer + ", Pris" + price + '}';
    }

}
