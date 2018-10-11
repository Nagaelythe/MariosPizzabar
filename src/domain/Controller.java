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

    }

    private OrderHandler OH = new OrderHandler();
    private final Scanner SC = new Scanner(System.in); // skal nok fjernes.
    private UI ui = new UI();
    private PizzasToMake PTM = new PizzasToMake();

    public void CreateOrder() {
        //Get UI Element from here.
        System.out.println("Indtast nr på den bestilte pizza: ");
        Order O = null;
        Pizza P = new Pizza(ui.getNumMinMax(0, 15));  // evt implementer UI metoder til at få et ID og et navn, eller lav en Json string til det her?

        //Creating more pizzas:
        ui.orderMore();
        if (ui.getYN()) {
            ArrayList<Pizza> Pz = new ArrayList<>();
            Pz.add(P);
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
            O = new Order(Pz, C);
            if (ui.confirmOrder(O)) {
                PTM.addPizzas(Pz, LocalDateTime.now());
                OH.newOrder(O);
            }
        } else {
            Customer C = new Customer(ui.getName(), ui.getPhone());
            O = new Order(P, C);
            if (ui.confirmOrder(O)) {
                PTM.addPizzas(P, LocalDateTime.now());
                OH.newOrder(O);
            }
        }
        new datasource.Receipt(O);

    }

    public void programMenu() {
        UI ui = new UI();
        Archive arch = new Archive();
        boolean stayin = true;
        while (stayin) {
            ui.getMenu();
            switch (ui.getNumMinMax(0, 5)) {

                case 1: {
                    printPizzaMenu(arch);
                    break;
                }
                case 2: {
                    showPTM();
                    break;
                }
                case 3: {
                    CreateOrder();
                    break;
                }
                case 4: {
                    completeOrder();
                    break;
                }
                case 5:
                    stayin = false;
                    break;
            }
        }
    }

    public void printPizzaMenu(Archive arch) {
        int index = 1;
        for (String string : arch.readPizzaCSVList()) {
            String[] pizzaDetaljer = string.split(",");
            System.out.println(index + ". " + pizzaDetaljer[0] + ", Alm: " + pizzaDetaljer[1]
                    + "kr, Deep pan: " + pizzaDetaljer[2] + "kr, Familie: "
                    + pizzaDetaljer[3] + "kr");
            index++;
        }
    }

    public void showPTM() {
        ui.dispPTM(PTM);

        if (PTM.noPTM()) {
            System.out.println("Ingen pizzaer mangler at blive lavet.");
            return;
        }
        System.out.println("1: fjern pizza fra arbejds liste. \n2: tilbage til hovedmenuen.");
        switch (ui.getNumMinMax(1, 2)) {
            case 1:
                if (PTM.size() == 1) {
                    PTM.pizzaComplete();
                } else {
                    PTM.pizzaComplete(ui.getNumMinMax(1, 10));
                    showPTM();
                }
                break;
            case 2:
                return;
        }

    }

    public void completeOrder() {
        System.out.println(OH);
        System.out.println("Hvilken bestilling bliver afhentet? tryk 0 at komme tilbage.");
        int input = ui.getNumMinMax(1, OH.size());
        if(input != 0) OH.completeOrder(input);
       
    }

}
