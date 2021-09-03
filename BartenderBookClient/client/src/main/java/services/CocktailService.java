package services;

import model.Cocktail;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class CocktailService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public CocktailService(String baseUrl, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    public Cocktail[] displayMenu(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);
        Cocktail[] cocktails = null;
        cocktails = restTemplate.exchange("http://localhost:8080/all",
                HttpMethod.GET, entity,
                Cocktail[].class).getBody();

        return cocktails;
    }

    public Cocktail getDrinkRecipe(String selection){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);
        Cocktail cocktailRecipe = restTemplate.exchange("http://localhost:8080/drinks/name",
                HttpMethod.GET, entity,
                Cocktail.class).getBody();

        return cocktailRecipe;
    }
}
