package org.example.util;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.example.functions.Time;
import org.example.responseModel.FlightResponseClass;
import org.example.responseModel.RouteResponseClass;

import java.util.List;

public class UIHelper {
    public static void setContentOfComboBox(ComboBox<String> comboBox, List<String> content){
        comboBox.setItems(FXCollections.observableArrayList(content));
        comboBox.getSelectionModel().selectFirst();
    }

    public static void addRouteCard(VBox container, RouteResponseClass route){
        VBox card = new VBox(5);
        card.setPadding(new Insets(10));
        card.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-color: #f9f9f9; -fx-background-radius: 5;");


        // Заголовок маршрута
        Label header = new Label("Отправление: " + route.getDeparture().replace('T', ' ').replace('-', ' ') + " → Прибытие: " + route.getArrival().replace('T', ' ').replace('-', ' '));
        header.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Label durationLabel = new Label("Время в пути: " + Time.TimeByDuration(route.getDuration()));

        VBox flightsBox = new VBox(3);
        int index = 1;
        for (FlightResponseClass flight : route.getFlights()) {
            Label flightLabel = new Label(index + "\n" +
                    "Время отправления: " + flight.getDeparture() + "\n" +
                    "Город отправления: " + flight.getDepartureCity().getCityName() + "\n" +
                    "Время прибытия: " + flight.getArrival() + "\n" +
                    "Город прибытия: " + flight.getArrivalCity().getCityName() + "\n" +
                    "Тип маршрута: " + flight.getFlightType() + "\n");
            flightsBox.getChildren().add(flightLabel);
            index++;
        }

        card.getChildren().addAll(header, durationLabel, flightsBox);
        container.getChildren().add(card);
    }
}
