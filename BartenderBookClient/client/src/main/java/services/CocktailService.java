package services;

import model.Cocktails;
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

    public Cocktails[] displayMenu(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);
        Cocktails[] cocktails = null;
        cocktails = restTemplate.exchange("http localhost:5432/all",
                HttpMethod.GET, entity,
                Cocktails[].class).getBody();

        return cocktails;
    }
}
