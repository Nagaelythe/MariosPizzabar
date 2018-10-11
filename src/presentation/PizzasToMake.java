/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Pizza;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class PizzasToMake {
    private ArrayList<Pizza> PTM = new ArrayList<>();
    private ArrayList<LocalDateTime> Time = new ArrayList<>();
    public PizzasToMake(){    
    }
    
    public void addPizzas(ArrayList<Pizza> P, LocalDateTime T){
        for (Pizza pizza : P) {
            this.PTM.add(pizza);
            this.Time.add(T);
        }        
    }
    public void addPizzas(Pizza P, LocalDateTime T){
        this.PTM.add(P);
        this.Time.add(T);
    }
    
    public boolean noPTM(){
        return PTM.isEmpty();
    }
    
    @Override
    public String toString(){
        String out = "";
        for (int i = 0; i < PTM.size(); i++) {
            out+= (i+1)  +  PTM.get(i).toString() +" " + Time.get(i) +". \n";
        }
        return out;
    }
    
    public void pizzaComplete(){
        PTM.remove(0);
        Time.remove(0);
    }
        public void pizzaComplete(int i){
        if (i<=0 || i>=this.PTM.size()) throw new IllegalArgumentException("gonn be a null pointer ma dude");
        PTM.remove(i-1);
        Time.remove(i-1);
    }
    
}
