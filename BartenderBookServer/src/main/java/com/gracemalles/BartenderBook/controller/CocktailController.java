package com.gracemalles.BartenderBook.controller;

import com.gracemalles.BartenderBook.dao.CocktailsDao;
import com.gracemalles.BartenderBook.model.Cocktails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CocktailController {

    // holds all of the endpoints
    // requests mapping / requestParam
    //

    @Autowired
    private CocktailsDao cocktailsDao;

//    public CocktailController(CocktailsDao cocktailsDao) {
//        this.cocktailsDao = cocktailsDao;
//    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Cocktails> getAllCocktails() {
        return cocktailsDao.getAllCocktails();
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Cocktails getCocktailByName(@PathVariable String name) {
        return cocktailsDao.searchCocktailByName(name);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Cocktails getCocktailById(@PathVariable Long id) {
        return cocktailsDao.searchCocktailByID(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public void addNewCocktailItem(String name, @RequestBody String ingredients,
                                                @RequestBody String recipe){
         cocktailsDao.addNewCocktailItem(name, ingredients, recipe);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
    public void deleteCocktail(@PathVariable String name){
        cocktailsDao.deleteCocktail(name);
    }


}
