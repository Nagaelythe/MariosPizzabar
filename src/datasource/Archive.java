package datasource;

import java.util.ArrayList;
import java.io.*;

import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/*readSmallTextToList
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Niels Bang
 */
public class Archive {

    private String workingDir = "";
    private final String filename = workingDir + "archive.bin";
    private final String menuPizzaFileName = System.getProperty("user.dir")
            + "/src/datasource/pizzaMenu.csv";
    private final String logger = System.getProperty("user.dir")
            + "/src/datasource/logger.txt";
    private final String customerFileName = workingDir + "customerFileName";
//    private final String menuPizzaFileName = workingDir +"pizzaMenu.csv";
    private final File archive = new File(filename);
    public boolean DEBUG = true; //true for debugging..

    private ArrayList<String> pizzaArrayList = new ArrayList();                      //menuPizza listen
    private Path pizzaFile;                 //menuPizza sti. Skal bruges af 
    //readPizzaCSVList nederst. 

    public void setWorkingDir(String dir) {
        workingDir = dir;
    }

    public ArrayList<domain.Order> getOrder(domain.Customer customer) {
        ArrayList<domain.Order> allOrders = readArchive();
        ArrayList<domain.Order> orders = new ArrayList<>();
        for (domain.Order o : allOrders) {
            if (o.customer.equals(customer)) {
                orders.add(o);
            }
        }
        return orders;
    }

    public void addToArchive(domain.Order order) {
        ObjectOutputStream objectOut;
        try {
            FileOutputStream fileOut = new FileOutputStream(archive);
            if (archive.exists()) {
                objectOut = new AppendObjectOutputStream(fileOut);
            } else {
                objectOut = new ObjectOutputStream(fileOut);
            }
            objectOut.writeObject(order);
            objectOut.flush();

        } catch (FileNotFoundException ex) {
            System.out.println("No orderfile created.");
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<domain.Order> readArchive() {
        ArrayList<domain.Order> obj = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream(archive);
            ObjectInputStream sin = new ObjectInputStream(in);
            while (true) {
                try {
                    obj.add((domain.Order) sin.readObject());
                } catch (EOFException ex) {
                    return obj;
                }
            }
        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public ArrayList<String> readPizzaCSVList() {

        //Pizzalisten til menu består af navn og priserne på alm,
        //deep pan og familie pizzaer
        //En liste returneres, som man må splitte hvor den bruges.
        try {
            pizzaFile = Paths.get(menuPizzaFileName);
            for (String string : Files.readAllLines(pizzaFile)) {
                pizzaArrayList.add(string);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pizzaArrayList;
    }

    public void writeWithNio(String errorString) {
        try {
            Path path = Paths.get(logger);
            String[] arr = new String[]{errorString};
            List<String> list = Arrays.asList(arr);
            Files.write(path, list);
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }

        }
    }

}
