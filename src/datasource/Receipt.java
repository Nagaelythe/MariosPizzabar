/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
       

/**
 *
 * @author Lord
 */
public class Receipt {

    private final String file = System.getProperty("user.dir")
            + "/src/datasource/Receipt.txt";
    private final Path path = Paths.get(file);
    private String name, phone;
    private ArrayList<String> receipt = new ArrayList<>();
    private ArrayList<domain.Pizza> pizzas;
    private final String art = " __  __            _       _       _____ _                \n"
                + "|  \\/  |          (_)     ( )     |  __ (_)              \n"
                + "| \\  / | __ _ _ __ _  ___ |/ ___  | |__) | __________ _  \n"
                + "| |\\/| |/ _` | '__| |/ _ \\  / __| |  ___/ |_  /_  / _` |\n"
                + "| |  | | (_| | |  | | (_) | \\__ \\ | |   | |/ / / / (_| |\n"
                + "|_|  |_|\\__,_|_|  |_|\\___/  |___/ |_|   |_/___/___\\__,_|";

    public Receipt(domain.Order order) {
        name = order.customer.getName();
        phone = "" + order.customer.getPhone();
        pizzas = order.getPizzas();
        
        buildReceipt();
        
        print();
        
        
        
    }

    public Receipt() {
    }//for testing

    private void buildReceipt(){
        receipt.add(art);
        receipt.add("Kunde:  " + name + "      tlf " + phone);
        receipt.add("Du blev betjent af xxxx \n");
               
        int sum = 0;
        for(domain.Pizza p: pizzas){
            receipt.add(p.toString());
            sum += p.getPrice();
        }
        receipt.add("Total: " + sum);
        receipt.add("\n Marios Pizzabar \n Lyngby Hovedgade x \n 2800 Kongens Lyngby \n");
        
        
    }
    
    private void print() {
        try{
        Files.write(path, receipt);
        } catch (IOException e){
            e.printStackTrace();
        }
       
    }
}
