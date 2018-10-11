/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import datasource.Archive;
import java.util.Scanner;

/**
 *
 * @author Martin Wulff
 */
public class UI {

    public final Scanner SC = new Scanner(System.in);

    /*
    public void displayPizzaMenu(ArrayList<Pizza> Menu){
        int Space = 30;
        String stars = StringUtils("*",32);
        
        
        //Building Menu:
        System.out.println(stars);
        System.out.println('*'+String.Utils(" ", 10) );
        
        
    }        
     */
    public UI() {

    }

    public void orderMore() {
        System.out.println("Bestiller kunden mere pizza? Y/N");
    }

    public void dispPTM(PizzasToMake PTM) {
        System.out.println(PTM);
    }

    public boolean confirmOrder(domain.Order O) {
        System.out.println("Kunden har bestilt en: " + O);
        System.out.println("Er det korrekt? Y/N");
        return getYN();

    }

    public int getNumMinMax(int min, int max) {
        Archive archive = new Archive();

        int num = 0;
        try {
            num = Integer.parseInt(SC.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input skal være et heltal!");
            archive.writeWithNio(e.getMessage());
            getNumMinMax(min, max);
        }
        if (num < min || num > max) {
            System.out.println("Indtast venligst et tal mellem " + min + " og " + max);
            num = getNumMinMax(min, max);
        }
        return num;
    }

    public boolean getYN() {

        String input = SC.nextLine();

        if (input.toLowerCase().startsWith("y")) {
            return true;
        } else if (input.toLowerCase().startsWith("n")) {
            return false;
        }
        System.out.print("Input forkert, prøv igen Y/N: ");
        return getYN();
    }

    public int getPhone() {
        System.out.println("Indtast kundens telefon nummer.");
        String in = SC.nextLine();
        int num = 0;
        try {
            num = Integer.parseInt(in);
        } catch (Exception e) {
            System.out.println("Telefon numrer må kun indeholde tal!");
            getPhone();
        }
        if (in.length() != 8) {
            System.out.println("Telefon numrer skal være på 8 cifrer.");
            getPhone();
        }
        return num;
    }

    public String getName() {
        System.out.println("Indtast navnet på kunden.");
        return SC.nextLine();
    }

    public void getMenu() {
        stars();
        System.out.println("1. Vis menu\n2. Vis bestillinger\n3. Opret ordre\n"
                + "4. Quit");
    }

    public void stars() {
        System.out.println("***************");
    }

}
