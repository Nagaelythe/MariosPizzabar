package datasource;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import java.nio.charset.Charset;
import java.nio.file.*;
        


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niels Bang
 */
public class Archive {
    private final String FILENAME = "archive.bin";
    private final String orderArchive = "orderArchive.bin";        
    private final File orderFile = new File(orderArchive);
    
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
    public void printReciept(int number) {
        
    }
    /*
    public void addToArchive(){
        FileOutputStream out = new FileOutputStream()
        AppendObjectOutputStream objectAppend = new AppendObjectOutputStream();
    }
    */
    public ArrayList<String> readArchive() {
        ArrayList<String> read = new ArrayList<>();
        
        return read;
    }
    
        public ArrayList<Object> readOrders() {
        ArrayList<Object> obj = new ArrayList<>();
        Object a = null;
        try {
            FileInputStream in = new FileInputStream(orderFile);
            ObjectInputStream sin = new ObjectInputStream(in);
            while(true){
                try{
                    obj.add(sin.readObject());
                } catch(EOFException ex){
                    return obj;
                }
            }
        } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            
        } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            
        }
        return obj;
    }
    
    
    public void readNIO() {
        try {
            Charset cs = Charset.forName("UTF-8");
            Path path = Paths.get(FILENAME);
            List<String> lines = Files.readAllLines(path, cs);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex){
            System.out.println("File not found.");
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
    /*
    public Order findOrder(int orderNumber){
        
    }
    */
    
}

class AppendObjectOutputStream extends ObjectOutputStream {

  public AppendObjectOutputStream(OutputStream out) throws IOException {
    super(out);
  }

  @Override
  protected void writeStreamHeader() throws IOException { //2tally not stolen from stackoverflow

    reset();
  }
  
}