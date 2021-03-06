/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 * This i s a class to handle the orders currently being processed, they are
 * supposedly "In the oven" It takes inputs from the controller class, and sends
 * its contents (orders) to be archived when they are flagged by the user as
 * done.
 *
 * 
 * 
 * @author Martin Wulff
 */
public class OrderHandler{

    private ArrayList<Order> Orders = new ArrayList<>();
    
    public OrderHandler(){
        Orders.clear();
    }
    
    private void controll() { //Placeholder. skal nok fjernes da den sikkert bliver redundant.
        for (Order o : Orders) {
            if (o.isDone()) {
                Orders.remove(o);
            }
        }
    }

    public void newOrder(Order o) {
        Orders.add(o);
    }

    public void completeOrder(int i) {

        // Send order to archive,
        Orders.remove(Orders.get(i));
    }


    public ArrayList<Order> in() {
        return Orders;
    }
    
    public int size(){
        return this.Orders.size();
    }
    
    @Override
    public String toString(){
        String out = "";
        int i = 1;
        for (Order O : Orders) {
            out+= i++ + O.toString() +"\n";
        }
        return out;
    }
}
