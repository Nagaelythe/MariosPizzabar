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
public class Ovnen {
    
    ArrayList<Odrer> Ib;
    
    
    
    public void controll(){
        for (Odrer o : Ib) {
            
            if(o.isDone) Ib.remove(o);
            
        }
    }
    
}
