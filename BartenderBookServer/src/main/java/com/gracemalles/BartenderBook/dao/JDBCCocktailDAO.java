package com.gracemalles.BartenderBook.dao;

import com.gracemalles.BartenderBook.model.Cocktails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCCocktailDAO implements CocktailsDao {

    private final JdbcTemplate jdbcTemplate;
    public JDBCCocktailDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Cocktails> getAllCocktails() {
    String sql = "SELECT * FROM cocktails";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Cocktails> cocktailsList = new ArrayList<>();
        while(results.next()){
            cocktailsList.add(mapResultsToCocktails(results));
        }
        return cocktailsList;
    }


    public Cocktails mapResultsToCocktails(SqlRowSet results){
    Cocktails cocktails = new Cocktails();
    Long cocktailId = results.getLong("cocktail_id");
    String name = results.getString("cocktail_name");
    String ingredients = results.getString("ingredients");
    String recipe = results.getString("recipe");

    cocktails.setId(cocktailId);
    cocktails.setName(name);
    cocktails.setIngredients(ingredients);
    cocktails.setRecipe(recipe);

    return cocktails;
    }


    @Override
    public Cocktails searchCocktailByName(String name) {
    String sql = "SELECT * FROM cocktails WHERE cocktail_name = ?";
    Cocktails cocktail = null;
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
    while(results.next()){
        cocktail = mapResultsToCocktails(results);

    }
        return cocktail;
    }

    @Override
    public Cocktails searchCocktailByID(Long id) {
    Cocktails cocktails = null;
    String sql = "SELECT * FROM cocktails WHERE cocktail_id = ?";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
    if(results.next()){
        cocktails = mapResultsToCocktails(results);
    }
        return cocktails;
    }

    @Override
    public void addNewCocktailItem(String name, String ingredients, String recipe) {
    String sql = "INSERT INTO cocktails(cocktail_name, ingredients, recipe)" +
                 "VALUES(?, ?, ?)";
    jdbcTemplate.update(sql,name, ingredients, recipe );

    }


    @Override
    public void deleteCocktail(String name) {
    String sql = "DELETE FROM cocktails WHERE name = ?";
    jdbcTemplate.update(sql, name);

    }
}
