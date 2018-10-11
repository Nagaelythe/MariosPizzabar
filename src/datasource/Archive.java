package datasource;

import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Niels Bang
 */
public class Archive {

    private String workingDir = "";
    private final String filename = workingDir + "archive.bin";
    private final String menuPizzaFileName = System.getProperty("user.dir")
            + "/src/datasource/pizzaMenu.csv";
    private final String statistik = System.getProperty("user.dir")
            + "/src/datasource/statistik.txt";
    private final String logger = System.getProperty("user.dir")
            + "/src/datasource/logger.txt";
    private final String customerFileName = workingDir + "customerFileName";
//    private final String menuPizzaFileName = workingDir +"pizzaMenu.csv";
    private final File archive = new File(filename);
    public boolean DEBUG = false; //true for debugging..

    private ArrayList<String> pizzaArrayList = new ArrayList();                      //menuPizza listen
    private Path pizzaFile;                 //menuPizza sti. Skal bruges af 
    //readPizzaCSVList nederst. 

    public void setWorkingDir(String dir) {
        workingDir = dir;
    }

    public ArrayList<String> getPizzaNames() {
        ArrayList<String> pizzas = readPizzaCSVList();
        ArrayList<String> pizzaNames = new ArrayList<>();
        String buffer = "";
        for (String s : pizzas) {
            buffer += s + '\n';
        }
        Pattern p = Pattern.compile("^(.*?),", Pattern.MULTILINE);
        Matcher m = p.matcher(buffer);
        while (m.find()) {
            pizzaNames.add(m.group(1));
        }
        return pizzaNames;
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

    public void writeLogger(String errorString) {
        try {
            Path path = Paths.get(logger);
            ArrayList<String> arr = new ArrayList<String>();
            List<String> list = new ArrayList<String>();
            list.add(errorString);
            for (String str : Files.readAllLines(path)) {
                list.add(str);
            }
            Files.write(path, list);
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }

        }
    }

}
