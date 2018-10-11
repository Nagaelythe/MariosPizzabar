/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datasource.Archive;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import presentation.PizzasToMake;
import presentation.UI;

/**
 *
 * @author Martin Wulff
 */
public class Controller {

    private OrderHandler oven = new OrderHandler();

    public static void main(String[] args) {
        new Controller().programMenu();
        new datasource.Receipt().drawArt();
        
        /* Receipt test
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(1, "Magheritta"));
        pizzas.add(new Pizza(12, "Torino"));
        pizzas.add(new Pizza(2, "Vesuvio"));
        new datasource.Receipt(new Order(pizzas, new Customer("John Testperson", 12345678)));
       */
        
        
    }

    private OrderHandler OH = new OrderHandler();
    private final Scanner SC = new Scanner(System.in); // skal nok fjernes.
    private UI ui = new UI();
    private PizzasToMake PTM = new PizzasToMake();

    public void CreateOrder() {
        //Get UI Element from here.
        System.out.println("Indtast nr på den bestilte pizza: ");
              
        Pizza P = new Pizza(ui.getNumMinMax(0, 15));  // evt implementer UI metoder til at få et ID og et navn, eller lav en Json string til det her?

        //Creating more pizzas:
        ui.orderMore();
        if (ui.getYN()) {
            ArrayList<Pizza> Pz = new ArrayList<>();
            System.out.println("Input pizza nr");
            P = new Pizza(ui.getNumMinMax(0, 15));
            Pz.add(P);
            ui.orderMore();
            while (ui.getYN()) {
                System.out.println("Input pizza nr");
                P = new Pizza(ui.getNumMinMax(0, 15));
                Pz.add(P);
                ui.orderMore();
            }
            Customer C = new Customer(ui.getName(), ui.getPhone());
            Order O = new Order(Pz, C);
            PTM.addPizzas(Pz, LocalDateTime.now());
            OH.newOrder(O);

        } else {
            Customer C = new Customer(ui.getName(), ui.getPhone());
            Order O = new Order(P, C);
            ui.confirmOrder(O);
            PTM.addPizzas(P, LocalDateTime.now());
            OH.newOrder(O);
        }
    }

    public void programMenu() {
        UI ui = new UI();
        Archive arch = new Archive();
        boolean stayin = true;
        while (stayin) {
            ui.getMenu();
            try {
                switch (ui.SC.nextLine()) {

                    case "1": {
                        int index = 1;
                        for (String string : arch.readPizzaCSVList()) {
                            String[] pizzaDetaljer = string.split(",");
                            System.out.println(index + ". " + pizzaDetaljer[0] + ", Alm: " + pizzaDetaljer[1]
                                    + "kr, Deep pan: " + pizzaDetaljer[2] + "kr, Familie: "
                                    + pizzaDetaljer[3] + "kr");
                            index++;
                        }
                        break;
                    }
                    case "2": {
                        showPTM();
                        break;
                    }
                    case "3": {
                        CreateOrder();
                        break;
                    }
                    case "4": {
                    }
                    case "5": {
                        stayin = false;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Indtast en rigtig værdi");
            }
        }
    }
    
    public void showPTM(){
        ui.dispPTM(PTM);
        
        if(PTM.noPTM()){
            System.out.println("Ingen pizzaer mangler at blive lavet.");
            return;
        }
        System.out.println("1: fjern pizza fra arbejds liste. \n2: tilbage til hovedmenuen.");
        switch(ui.getNumMinMax(1, 2)){
            case 1:
                    PTM.pizzaComplete(ui.getNumMinMax(1, 10));
                    showPTM();
                    break;
            case 2:
                    return;
            }
        
        
    }
    
    
    
}
