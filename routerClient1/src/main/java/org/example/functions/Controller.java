package org.example.functions;

import org.example.responseModel.RouteResponseClass;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    private final String routeUrl = "http://localhost:8080/api/flights";
    private final String citiesUrl = "http://localhost:8080/api/cities";
    private final String flightTypeUrl = "http://localhost:8080/api/types";

    private final RestTemplate restTemplate = new RestTemplate();
    private final RestTemplate citiesRestTemplate = new RestTemplate();
    private final RestTemplate flightTypeRestTemplate = new RestTemplate();

    public void route(){
        while (true){
            this.getRoute();
            Scanner scanner = new Scanner(System.in);
        }
    }

    private void getRoute(){
        final List<String> chosenCities = InformationOfRoute.chooseCities(citiesRestTemplate.getForObject(citiesUrl, List.class));

        final Map<String, String> data = new LinkedHashMap<>();
        data.put("departureCity", chosenCities.get(0));
        data.put("arrivalCity", chosenCities.get(1));
        data.put("departure", "2025-05-08T06:00:00Z");
        data.put("type", InformationOfRoute.chooseFlightType(flightTypeRestTemplate.getForObject(flightTypeUrl, List.class)));


        System.out.println("Начат поиск маршрута");
        System.out.println("Город отправления: " + data.get("departureCity"));
        System.out.println("Город прибытия: " + data.get("arrivalCity"));
        System.out.println("Время отправления: " + data.get("departure").replace('T', ' ').replace('Z', ' '));
        System.out.println("Тип маршрута: " + data.get("type"));
        System.out.println();

        System.out.println("Найденные маршруты:");

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(data);


        List<RouteResponseClass> responseClasses =
                restTemplate.exchange(
                        routeUrl,
                        HttpMethod.POST,
                        httpEntity,
                        new ParameterizedTypeReference<List<RouteResponseClass>>() {}
                ).getBody();

        InformationOfRoute.outputOfRoute(responseClasses);
    }
}
