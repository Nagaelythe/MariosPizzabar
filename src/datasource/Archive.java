package datasource;

import java.util.ArrayList;
import java.io.*;

import java.nio.file.*;

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
    private final String FILENAME = workingDir + "archive.bin";
    private final String orderArchive = workingDir + "orderArchive.bin";
    private final String menuFileName = workingDir + "menu.bin";
    private final String menuPizzaFileName = System.getProperty("user.dir")
            + "/src/datasource/pizzaMenu.csv";
    private final String customerFileName = workingDir + "customerFileName";
//    private final String menuPizzaFileName = workingDir +"pizzaMenu.csv";
    private final File orderFile = new File(orderArchive);
    private final File menuFile = new File(menuFileName);
    private final File customerFile = new File(customerFileName);
    public boolean DEBUG = true; //true for debugging..

    private ArrayList<String> pizzaArrayList = new ArrayList();                      //menuPizza listen
    private Path pizzaFile;                 //menuPizza sti. Skal bruges af 
    //readPizzaCSVList nederst. 

    /*
    Creates the archive to store orders, customers and 
    
     */
 /*
    
    public void createNewArchive(String fileName) {
        try{
        FileOutputStream fileOut = new FileOutputStream(fileName);
        }catch(IOException e){
            System.out.println("ya dun goofd");
        }
        
    }
     */
    public void ArchiveTest() {

    }

    public void setWorkingDir(String dir) {
        workingDir = dir;
    }

    public domain.Order getOrder(int number) {
        ArrayList<domain.Order> allOrders = readOrderArchive();
        domain.Order reciept = null;
        for (domain.Order o : allOrders) {
            //   if (o.Customer.equals(customer)) {
            reciept = o; //skal have et ordernummer
            // }
        }
        return reciept;
    }

    public ArrayList<domain.Order> getOrder(domain.Customer customer) {
        ArrayList<domain.Order> allOrders = readOrderArchive();
        ArrayList<domain.Order> orders = new ArrayList<>();
        for (domain.Order o : allOrders) {
            if (o.customer.equals(customer)) {
                orders.add(o);
            }
        }
        return orders;
    }

    public domain.Customer getCustomer(domain.Customer customer) {
        ArrayList<domain.Customer> allCustomers = readCustomerArchive();

        for (domain.Customer c : allCustomers) {
            if (c.equals(customer)) {
                return c;
            }
        }
        //    throw new UserNotFoundException();
//        throw new Exception();
        return null;
    }

    /*
    public void addToArchive(){
        FileOutputStream out = new FileOutputStream()
        AppendObjectOutputStream objectAppend = new AppendObjectOutputStream();
    }
     */
    public void addOrderToArchive(domain.Order order) {
        try {
            FileOutputStream fileOut = new FileOutputStream(orderFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
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

    public ArrayList<domain.Order> readOrderArchive() {
        ArrayList<domain.Order> obj = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream(orderFile);
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

    public ArrayList<domain.Customer> readCustomerArchive() {
        ArrayList<domain.Customer> obj = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream(customerFile);
            ObjectInputStream sin = new ObjectInputStream(in);
            while (true) {
                try {
                    obj.add((domain.Customer) sin.readObject());
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


    /*
    public void readNIO() {
        try {
            Charset cs = Charset.forName("UTF-8");
            Path path = Paths.get(FILENAME);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
            System.out.println("File not found.");
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
    }

    
    public Order findOrder(int orderNumber){
        
    }
     */
    public void saveMenu(ArrayList<domain.Pizza> menu) {
        try {
            FileOutputStream fileOut = new FileOutputStream(menuFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(menu);

            objectOut.flush();
            objectOut.close();

        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
            System.out.println("File not found");
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } finally {

        }

    }

    public void addToMenu(domain.Pizza Pizza) {
        try {
            FileOutputStream fileOut = new FileOutputStream(menuFile);
            AppendObjectOutputStream pizzaOut = new AppendObjectOutputStream(fileOut);
            pizzaOut.writeObject(Pizza);
            pizzaOut.flush();
            pizzaOut.close();

        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();

            }
        }
    }

    public ArrayList<String> readPizzaCSVList() {
        //Pizzalisten til menu består af navn og priserne på alm,
        //deep pan og familie pizzaer
        //En liste returneres, som man må splitte hvor den bruges.
        //List-listen er det eneste readAllLines vil returnere.

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

}
