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
public class Pizza {
    private int number;
    private String name;
    ArrayList<String> extraTopping = new ArrayList<>();
    private int price=0;
    
    public Pizza(int number, String name){
        this.name = name;
        this.number = number;   
        System.out.println("somethin");
        
    }
    //overload
    public Pizza(int Number){
        // Find pizzaen ud fra menuen.
    }
    
    public Pizza(String name){
        // find pizzaen ud fra menuen.
    }
    
    public void addTopping(String topping){
        extraTopping.add(topping);
        price++;
    }
    
    public void changeOrder(int number, String name){
        this.name = name;
        this.number = number;    
    }

    @Override
    public String toString() {
        return "Pizza " + number + ", " + name + "        " + price + " dkk ";
    }
    
    public int getPrice(){
        return price;
    }
    
    
    
}
