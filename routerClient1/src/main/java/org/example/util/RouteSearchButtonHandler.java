package org.example.util;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import org.example.functions.Controller;
import org.example.functions.InformationOfRoute;
import org.example.responseModel.RouteResponseClass;
import org.springframework.http.HttpEntity;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RouteSearchButtonHandler {
    public static void handleSearch(ComboBox<String> departureCityBox,
                                    ComboBox<String> arrivalCityBox,
                                    DatePicker departureDatePicker,
                                    ComboBox<String> flightTypeBox,
                                    VBox routesBox) {


        Controller controller = new Controller();
        String departureCity = departureCityBox.getValue();
        String arrivalCity = arrivalCityBox.getValue();
        LocalDate date = departureDatePicker.getValue();
        String flightType = flightTypeBox.getValue();


        if (arrivalCity.equals(departureCity)) {
            return;
        }

        final Map<String, String> data = new LinkedHashMap<>();
        data.put("departureCity", departureCity);
        data.put("arrivalCity", arrivalCity);
        data.put("departure", date + "T00:00:00Z");
        data.put("type", flightType);

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(data);

        List<RouteResponseClass> routeResponseClasses = controller.getRouteFromREST(httpEntity);
        routesBox.getChildren().clear();
        for (RouteResponseClass route : routeResponseClasses) {
            UIHelper.addRouteCard(routesBox, route);
        }
    }
}
