package org.example.functions;

import org.example.responseModel.FlightResponseClass;
import org.example.responseModel.RouteResponseClass;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InformationOfRoute {
    public static List<String> chooseCities(List<String> cities) {
        System.out.println("Выберите город отправления: ");
        Scanner scanner = new Scanner(System.in);
        IntStream.range(0, cities.size())
                .forEach(i -> System.out.println((i) + ". " + cities.get(i)));

        int firstCity = scanner.nextInt();
        if (firstCity >= cities.size() || firstCity < 0) {
            System.exit(0);
        }
        String departureCity = cities.get(firstCity);
        cities.remove(departureCity);

        System.out.println("Выберите город прибытия: ");
        IntStream.range(0, cities.size())
                .forEach(i -> System.out.println((i) + ". " + cities.get(i)));

        int secondCity = scanner.nextInt();
        if (secondCity >= cities.size() || secondCity < 0) {
            System.exit(0);
        }
        String arrivalCity = cities.get(secondCity);

        return List.of(departureCity, arrivalCity);
    }

    public static String chooseFlightType(List<String> flights) {
        System.out.println("Выберите тип марширута");
        Scanner scanner = new Scanner(System.in);
        IntStream.range(0, flights.size())
                .forEach(i -> System.out.println((i) + ". " + flights.get(i)));

        int type = scanner.nextInt();
        if (type >= flights.size() || type < 0) {
            System.exit(0);
        }

        return flights.get(type);
    }

    public static void outputOfRoute(List<RouteResponseClass> responseClasses) {
        for (RouteResponseClass routeResponseClass : responseClasses) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Отправление: " + routeResponseClass.getDeparture().replace('T', ' '));
            System.out.println("Прибытие: " + routeResponseClass.getArrival().replace('T', ' '));
            System.out.println("Время в пути: " + Time.TimeByDuration(routeResponseClass.getDuration()));
            System.out.println();
            System.out.println("Маршрут:\n");
            int count = 1;
            for (FlightResponseClass flightResponseClass : routeResponseClass.getFlights()) {
                System.out.println(count);
                System.out.println("Время отправления: " + flightResponseClass.getDeparture().replace('T', ' '));
                System.out.println("Город отправления: " + flightResponseClass.getDepartureCity().getCityName());
                System.out.println("Время прибытия : " + flightResponseClass.getArrival().replace('T', ' '));
                System.out.println("Город прибытия: " + flightResponseClass.getArrivalCity().getCityName());
                System.out.println("Тип маршрута: " + flightResponseClass.getFlightType());
                System.out.println();
                count++;
            }
        }
    }
}
