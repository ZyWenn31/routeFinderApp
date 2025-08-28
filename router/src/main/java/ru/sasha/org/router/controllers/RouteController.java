package ru.sasha.org.router.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sasha.org.router.dto.RouteDTO;
import ru.sasha.org.router.dto.TargetRoute;
import ru.sasha.org.router.services.CityService;
import ru.sasha.org.router.services.FlightService;
import ru.sasha.org.router.util.FlightType;
import ru.sasha.org.router.util.exceptions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class RouteController {

    private final FlightService flightService;
    private final CityService cityService;

    public RouteController(FlightService flightService, CityService cityService) {
        this.flightService = flightService;
        this.cityService = cityService;
    }

    @PostMapping("/api/flights")
    public List<RouteDTO> getFlightsByInfo(@RequestBody @Valid TargetRoute targetRoute,
                                                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new CityNotValidException(CreateMessageError.createMessageError(bindingResult));
        }

        return flightService.createTargetRoutes(targetRoute).getFlightDTOList();
    }

    @GetMapping("/api/cities")
    public List<String> getCities(){
        return cityService.getAllCityNames();
    }

    @GetMapping("/api/types")
    public List<String> getTypes(){
        return Arrays.stream(FlightType.values())
                .map(FlightType::name)
                .collect(Collectors.toList());
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> CityNotFound(CityNotFoundException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> CityNotValid(CityNotValidException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> RouteTypeNotFound(RouteTypeNotFindException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}


