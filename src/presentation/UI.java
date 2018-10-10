/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author Martin Wulff
 */
public class UI{
    
    public final Scanner SC = new Scanner(System.in);
    
    public void displayPizzaMenu(ArrayList<Pizza> Menu){
        int Space = 30;
        String stars = StringUtils("*",32);
        
        
        //Building Menu:
        System.out.println(stars);
        System.out.println('*'+StringUtils(" ", 10) );
        
        
    }        
            
            
    public int getMenuNavigation(int min, int max) {
        int num = 0;
        try {
            num = Integer.parseInt(SC.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input skal være et heltal!");
            getInput(min,max);
        }
        if (num < min || num > max) {
            System.out.println("Indtast venligst et tal mellem " + min + " og " + max);
            num = getInput(min, max);
        }
        return num;
    }
    
    
    
    public int getPhoneNumber() {
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
    
    
}
