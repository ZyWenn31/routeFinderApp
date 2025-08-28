package org.example.responseModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class RouteResponseClass {
    private List<FlightResponseClass> flights;
    private String departure;
    private String arrival;
    private long duration;

    public List<FlightResponseClass> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightResponseClass> flights) {
        this.flights = flights;
    }

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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
