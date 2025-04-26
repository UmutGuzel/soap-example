package com.umut.soap.service;

import com.example.soap.gen.Country;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {
    private static final Map<String, Country> countries = new HashMap<>();

    static {
        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setPopulation(10);

        Country pl = new Country();
        pl.setName("Poland");
        pl.setCapital("Warsaw");
        pl.setPopulation(5);

        countries.put("United  Kingdom", uk);
        countries.put("Poland", pl);
    }

    public Country findCountry(String name){
        return countries.get(name);
    }
}
