/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datasource.Archive;
import java.util.ArrayList;
import java.util.Scanner;
import presentation.UI;

/**
 *
 * @author Martin Wulff
 */
public class Controller {

    private OrderHandler oven = new OrderHandler();

    public static void main(String[] args) {
        //new Controller().programMenu();
        //new datasource.Receipt().drawArt();
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(1, "Magheritta"));
        pizzas.add(new Pizza(12, "Torino"));
        pizzas.add(new Pizza(2, "Vesuvio"));
        new datasource.Receipt(new Order(pizzas, new Customer("John Testperson", 12345678)));
       
        
        
    }

  

    private OrderHandler OH = new OrderHandler();
    private final Scanner SC = new Scanner(System.in); // skal nok fjernes.
    private UI ui = new UI();

    public void CreateOrder() {
        //Get UI Element from here.
        Pizza P = new Pizza(ui.getNumMinMax(0, 15));  // evt implementer UI metoder til at få et ID og et navn, eller lav en Json string til det her?

        //Creating more pizzas:
        ui.orderMore();
        if (ui.getYN()) {
            ArrayList<Pizza> Pz = new ArrayList<>();
            P = new Pizza(ui.getNumMinMax(0, 15));
            Pz.add(P);
            ui.orderMore();
            while (ui.getYN()) {
                P = new Pizza(ui.getNumMinMax(0, 15));
                Pz.add(P);
                ui.orderMore();
            }
            Customer C = new Customer(ui.getName(), ui.getPhone());
            Order O = new Order(Pz, C);

        } else {
            Customer C = new Customer(ui.getName(), ui.getPhone());
            Order O = new Order(P, C);
            ui.confirmOrder(O);
            OH.newOrder(O);
        }

    }

    public void programMenu() {
        UI ui=new UI();
        Archive arch = new Archive();
        boolean stayin = true;
        while (stayin) {
            try {
                switch (ui.SC.nextLine()) {

                    case "1": {
                        
                        break;
                    }
                    case "2": {
                        break;
                    }
                    case "3": {
                        stayin = false;
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Indtast en rigtig værdi");
            }
        }
    }

}
