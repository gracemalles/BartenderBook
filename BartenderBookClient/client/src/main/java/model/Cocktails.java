package model;

public class Cocktails {

    private Long id;
    private String name;
    private String ingredients;
    private String recipe;


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

