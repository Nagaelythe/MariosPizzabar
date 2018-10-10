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
public class Ovnen{
    
    private ArrayList<Order> Ib;
    
    
    
    private void controll(){
        for (Order o : Ib) {
            if(o.isDone()) Ib.remove(o);
        }
    }
    public void newOdrer(Order o){
        Ib.add(o);
        
        controll();
    }
    
    public void completteOrder(Order o){   
        if(!Ib.contains(o)) throw new IllegalArgumentException();
        // Send order to archive,
        Ib.remove(o);
        
    }
    
}
