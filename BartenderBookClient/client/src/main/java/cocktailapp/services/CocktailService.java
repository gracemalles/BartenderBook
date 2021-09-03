package cocktailapp.services;

import cocktailapp.model.Cocktail;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class CocktailService {

    private String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();


    public CocktailService(String baseUrl) {
        this.baseUrl = baseUrl;

    }


//    public Cocktail[] displayMenu(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity entity = new HttpEntity(httpHeaders);
//
//        Cocktail [] cocktails = null;
//
//       ResponseEntity<Cocktail []> response = restTemplate.exchange("http://localhost:8080/all",
//                HttpMethod.GET, entity,
//                Cocktail[].class);
//
//       cocktails = response.getBody();
//
//
//
////        String stuff = restTemplate.exchange("http://localhost:8080/all",
////                HttpMethod.GET, entity,
////                String.class).getBody();
////
////        System.out.println(stuff);
//
//        return cocktails;
//    }

    public Cocktail[] displayMenu(){

        Cocktail [] cocktails = null;
        try {
            cocktails = restTemplate.getForObject("http://localhost:8080/all", Cocktail[].class);
        } catch (RestClientResponseException e){
            System.out.println("error " + e);
        } catch (ResourceAccessException x){
            System.out.println("resource error " + x);
        }
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
