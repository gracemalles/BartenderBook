package com.gracemalles.BartenderBook.dao;

import com.gracemalles.BartenderBook.model.Cocktails;

import java.util.List;

public interface CocktailsDao {

    public List<Cocktails> getAllCocktails();

    public Cocktails searchCocktailByName(String name);

    public Cocktails searchCocktailByID(Long id);

    public void addNewCocktailItem(Cocktails cocktails);

    public void deleteCocktail(String name);


}

