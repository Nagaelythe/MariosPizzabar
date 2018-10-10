/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Scanner;

/**
 *
 * @author Martin Wulff
 */
public class Controller {
    private Oven Oven = new Oven();
    private final Scanner SC = new Scanner(System.in); // skal nok fjernes.
    
    
    public void CreateOrder(){
        //Get UI Element from here.
        Pizza P = new Pizza(ID,Name);  // evt implementer UI metoder til at få et ID og et navn, eller lav en Json string til det her?
        // Check Database for Customer.
        //else{
        Customer C = new Customer(name, phone); // Evt UI Funktioner for at få disse oplysninger.
        
        
        Oven.newOrder(P,C);
    }
    

    
    public static int getNumber() {
        int num = 0;
        try {
            num = Integer.parseInt(SC.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a number!");
            num = getNumber();
        }
        return num;
    }

    
}
