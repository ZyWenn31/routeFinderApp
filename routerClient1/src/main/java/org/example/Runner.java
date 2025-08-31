package org.example;

import org.example.functions.Controller;
import org.example.functions.InformationOfRoute;
import org.example.responseModel.RouteResponseClass;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.route();
    }
}
