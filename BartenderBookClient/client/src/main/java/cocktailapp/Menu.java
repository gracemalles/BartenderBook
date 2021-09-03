package cocktailapp;

import cocktailapp.model.Cocktail;
import org.springframework.web.client.RestTemplate;
import cocktailapp.services.CocktailService;

import java.util.Scanner;

public class Menu {

    private boolean exit;
    private CocktailService cs = new CocktailService("http://localhost:8080\"");
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      Menu menu = new Menu();
        menu.runMenu();
    }


    public void runMenu(){
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInputMainMenu();
            performActionMainMenu(choice);
        }
    }
    private void printHeader(){
        System.out.println("---------------------------------------------");
        System.out.println("     Welcome to the Bartender Book"          );
        System.out.println("                                             ");
        System.out.println("---------------------------------------------");
    }

    private void printMenu(){
        System.out.println("\nPlease make a selection:");
        System.out.println("(1) Display Cocktails");
        System.out.println("(2) Edit cocktailapp.model.Menu");
        System.out.println("(3) Exit");
    }

    private int getInputMainMenu(){

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

    private int getInputSubMenu(){
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


    private void performActionMainMenu(int choice){
        switch(choice){
            case 1:
                displayMenu();
                break;
            case 2:
                editMenu();
                break;
            case 3:
                exit = true;
                System.out.println("Thank you for using the Bartender Book!");
                break;
            default:
                System.out.println("An unknown error has occurred. Please try again!");
        }
    }
    private void displayMenu(){
        Cocktail[] cocktailsList  = cs.displayMenu();

        for(Cocktail cocktails : cocktailsList){
            System.out.println(cocktails.getId() + ") " + cocktails.getName());
        }
        displayDrink();

    }

    private void displayDrink(){
        System.out.println("Please enter your cocktail selection: ");
        String selection = scanner.nextLine();
        cs.getDrinkRecipe(selection);
    }

    private void editMenu(){
        System.out.println("\nPlease make a selection:");
        System.out.println("(1) Add cocktail to Bartender Book");
        System.out.println("(2) Remove cocktail to Bartender Book");

        getInputSubMenu();

    }

    private void performActionEditMenu(int choice){
        switch(choice){
            case 1:
                addCocktail();
                break;
            case 2:
                removeCocktail();
                break;
            case 3:
                exit = true;
                System.out.println("Thank you for using the Bartender Book!");
                break;
            default:
                System.out.println("An unknown error has occurred. Please try again!");
        }
    }
    private void addCocktail(){
        System.out.println("working");
    }

    private void removeCocktail(){


    }



}
