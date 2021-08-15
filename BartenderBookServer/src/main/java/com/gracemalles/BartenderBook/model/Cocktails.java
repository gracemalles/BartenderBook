package com.gracemalles.BartenderBook.model;

public class Cocktails {
    private Long id;
    private String name;
    private String ingredients;
    private String recipe;


    public Cocktails(Long id,String name, String ingredients, String recipe) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.recipe = recipe;

    }

    public Cocktails() {

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
