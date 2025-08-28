package org.example.responseModel;

import java.time.LocalDateTime;

public class FlightResponseClass {
    private String departure;
    private String arrival;
    private CityResponseClass departureCity;
    private CityResponseClass arrivalCity;
    private String flightType;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public CityResponseClass getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(CityResponseClass departureCity) {
        this.departureCity = departureCity;
    }

    public CityResponseClass getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(CityResponseClass arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
}
