package ru.sasha.org.router.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TargetRoute {

    @NotNull(message = "Departure city must not be null")
    private String departureCity;

    @NotNull(message = "Arrival city must not be null")
    private String arrivalCity;

    @NotNull(message = "Departure date must not be null")
    //Включить данную аннотацию после тестов: @FutureOrPresent(message = "Departure date must be in the present or future")
    private LocalDateTime departure;

    @NotNull(message = "Flight type must not be null")
    private String type;

    public @NotNull(message = "Departure city must not be null") String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(@NotNull(message = "Departure city must not be null") String departureCity) {
        this.departureCity = departureCity;
    }

    public @NotNull(message = "Arrival city must not be null") String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(@NotNull(message = "Arrival city must not be null") String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public  LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture( LocalDateTime departure) {
        this.departure = departure;
    }

    public @NotNull(message = "Flight type must not be null") String getType() {
        return type;
    }

    public void setType(@NotNull(message = "Flight type must not be null") String type) {
        this.type = type;
    }
}
