package ru.sasha.org.router.services;

import org.springframework.stereotype.Service;
import ru.sasha.org.router.model.City;
import ru.sasha.org.router.repository.CityRepository;
import ru.sasha.org.router.util.exceptions.CityNotFoundException;

import javax.swing.event.ListDataEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public City findCityByNAme(String cityTame){
        return cityRepository.findByCityName(cityTame)
                .orElseThrow(()-> new CityNotFoundException("City with name '" + cityTame + "' not found"));
    }

    public List<String> getAllCityNames(){
        return cityRepository.findAll()
                .stream()
                .map(City::getCityName)
                .collect(Collectors.toList());
    }
}
