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
public class Odrer {
    private Pizza pizza;
    private Kunde kunde;
    private boolean afhentet = false;
    
    public Odrer(Pizza pizza, Kunde kunde){
        this.pizza = pizza;
        this.kunde = kunde;
    }
    public void afhented(){
        this.afhentet = true;
    }
    
    public boolean isDone(){
        return afhentet;
    }
}
