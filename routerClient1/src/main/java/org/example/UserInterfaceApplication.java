package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.functions.Controller;
import org.example.util.RouteSearchButtonHandler;
import org.example.util.UIHelper;

import java.time.LocalDate;
import java.util.List;

public class UserInterfaceApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        ComboBox<String> departureCityBox = new ComboBox<>();
        ComboBox<String> arrivalCityBox = new ComboBox<>();
        ComboBox<String> flightTypeBox = new ComboBox<>();
        DatePicker departureDatePicker = new DatePicker(LocalDate.now());
        Button searchButton = new Button("Найти маршруты");
        VBox routesBox = new VBox(10); // отступы между карточками
        ScrollPane scrollPane = new ScrollPane(routesBox); // чтобы можно было скроллить

        routesBox.setPadding(new Insets(10));
        scrollPane.setFitToWidth(true);

        List<String> cities = controller.getCitiesFromREST();

        UIHelper.setContentOfComboBox(departureCityBox, cities);
        UIHelper.setContentOfComboBox(arrivalCityBox, cities);
        UIHelper.setContentOfComboBox(flightTypeBox, controller.getFlightTypeFromREST());


        searchButton.setOnAction(e -> RouteSearchButtonHandler.handleSearch(departureCityBox, arrivalCityBox, departureDatePicker, flightTypeBox, routesBox));
        VBox root = new VBox(10, departureCityBox, arrivalCityBox, departureDatePicker, flightTypeBox, searchButton, routesBox, scrollPane);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 600, 700));
        stage.setTitle("Поиск маршрутов");
        stage.show();
    }
}
