package com.gracemalles.BartenderBook.view;

import com.techelevator.view.Menu;
import com.gracemalles.BartenderBook.dao.CocktailsDao;
import com.gracemalles.BartenderBook.model.Cocktails;

import java.util.List;
import java.util.Scanner;

public class BartenderBookCLI {


    private static final String MAIN_MENU_OPTION_DISPLAY_COCKTAILS = "Display Cocktails";
    private static final String MAIN_MENU_OPTION_EDIT_MENU = "Edit Menu";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_COCKTAILS, MAIN_MENU_OPTION_EDIT_MENU, MAIN_MENU_OPTION_EXIT};

    // Display Cocktails Menu
    private static final String DISPLAY_COCKTAILS_MENU_OPTION_CREATE_COCKTAIL = "Which cocktail would you like to create?";
    private static final String DISPLAY_COCKTAILS_MENU_OPTION_RETURN_TO_MAIN = "Return to Main Menu";
    private static final String[] DISPLAY_COCKTAILS_MENU_OPTIONS = {DISPLAY_COCKTAILS_MENU_OPTION_CREATE_COCKTAIL,
            DISPLAY_COCKTAILS_MENU_OPTION_RETURN_TO_MAIN};


    //Edit Menu Option
    private static final String DISPLAY_EDIT_MENU_OPTION_UPDATE_EXISTING_MENU = "Update Existing Menu Item";
    private static final String DISPLAY_EDIT_MENU_OPTION_UPDATE_NEW_ITEM = "Add New Menu Item";
    private static final String DISPLAY_EDIT_MENU_OPTION_RETURN_TO_MAIN = "Return to Main Menu";
    private static final String[] DISPLAY_EDIT_MENU_OPTIONS = {DISPLAY_EDIT_MENU_OPTION_UPDATE_EXISTING_MENU,
            DISPLAY_EDIT_MENU_OPTION_UPDATE_NEW_ITEM,
            DISPLAY_EDIT_MENU_OPTION_RETURN_TO_MAIN};

    private final Scanner scanner = new Scanner(System.in);
    private Menu menu;
    private CocktailsDao cocktailsDao;

// move to client project
   /* public void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cocktail-database");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        run();
    }*/

    public void run() {
        boolean shouldLoop = true;
        while (shouldLoop) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_COCKTAILS)) {
                displayMenu();

            } else if (choice.equals(MAIN_MENU_OPTION_EDIT_MENU)) {
                editMenu();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                shouldLoop = false;
            }
        }
    }


    private void displayMenu() {
        List<Cocktails> cocktailsList = cocktailsDao.getAllCocktails();
        System.out.println(cocktailsList);

        System.out.println("What cocktail do you want to create: ");
        System.out.println("Please enter serving size: ");
        System.out.println("Please enter measurement preference (O)z or (C)ups: ");

    }

    public void cupsConversion(double oz){
        double cups = oz / 0.125;

    }


    private void editMenu() {
        System.out.println("Do you want to (update) an existing menu item" +
                "or add a (new) item");

    }



}