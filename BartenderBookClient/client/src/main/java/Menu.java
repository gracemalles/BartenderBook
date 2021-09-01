import model.Cocktails;
import services.CocktailService;

import java.awt.*;
import java.util.Scanner;

public class Menu {

    private boolean exit;
    private CocktailService cs;

    public static void main(String[] args) {
      Menu menu = new Menu();
        menu.runMenu();
    }

    public void runMenu(){
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    private void printHeader(){
        System.out.println("---------------------------------------------");
        System.out.println("     Welcome to the Bartending Book"          );
        System.out.println("                                             ");
        System.out.println("---------------------------------------------");
    }

    private void printMenu(){
        System.out.println("\nPlease make a selection:");
        System.out.println("(1) Display Cocktails");
        System.out.println("(2) Edit Menu");
        System.out.println("(3) Exit");
    }

    private int getInput(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice < 1 || choice > 2){
            try{
                System.out.println("\nEnter your choice:");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid selection. Please try Again");
            }
        }
        return choice;
    }
    private void performAction(int choice){
        switch(choice){
            case 1:
                displayMenu();
                break;
            case 2:
                editMenu();
            case 3:
                exit = true;
                System.out.println("Thank you for using the Bartender Book!");
            default:
                System.out.println("An unknown error has occurred. Please try again!");
        }
    }
    private void displayMenu(){
        Cocktails[] cocktailsList  = cs.displayMenu();

        for(Cocktails cocktails : cocktailsList){
            System.out.println(cocktails.getId() + ") " + cocktails.getName());
        }
      String drinkSelection = System.out.println("Please enter your cocktail selection");


    }

    private void editMenu(){

    }
}
