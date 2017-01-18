package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Brazil", 205823665, "Brasilia", Arrays.asList("Portuguese")),
            new Country("Hungary", 9874784, "Budapest", Arrays.asList("Hungarian")),
            new Country("Mexico", 123166749, "Mexico City", Arrays.asList("Spanish")),
            new Country("Cameroon", 24360803, "Yaounde", Arrays.asList("English", "French")),
            new Country("Uruguay", 3351016, "Montevideo", Arrays.asList("Spanish"))
    );

    // Uses a stream to filter data for finding a single country by country name
    public Country findByName(String name) {
        return ALL_COUNTRIES.stream().filter(country -> country.getName().equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    // Uses a stream to sort the list of countries by country name
    public List<Country> sortByName() {
        return ALL_COUNTRIES.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).collect(Collectors.toList());
    }

    // Uses a stream to sort the list of countries by country population
    public List<Country> sortByPopulation() {
        return ALL_COUNTRIES.stream().sorted((c1, c2) -> c1.getPopulationAsInt() - c2.getPopulationAsInt()).collect(Collectors.toList());
    }
}
