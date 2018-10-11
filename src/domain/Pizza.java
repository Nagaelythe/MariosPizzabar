/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datasource.Archive;
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
    private Archive arch = new Archive();
    
    public Pizza(int number, String name){
        this.name = name;
        this.number = number;   
        System.out.println("somethin");
        
    }
    //overload
    public Pizza(int Number,int type){
        this.number = Number;
        String[] info = arch.readPizzaCSVList().get(Number).split(",");
        this.name = info[0];
        this.price = Integer.parseInt(info[type]);
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
        return "Pizza nr. " + number + ", " + name + "        " + price + " dkk ";
    }
    
    public int getPrice(){
        return price;
    }
    
    
    
}
