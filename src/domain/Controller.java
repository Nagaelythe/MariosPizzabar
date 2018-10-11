/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Scanner;
import presentation.UI;

/**
 *
 * @author Martin Wulff
 */
public class Controller {

    private OrderHandler oven = new OrderHandler();
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
            oven.newOrder(O);
        }

    }

    public void programMenu() {
        
    }

}
