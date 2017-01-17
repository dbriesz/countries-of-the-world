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
            new Country("Cameroon", 24360803, "Yaounde", Arrays.asList("English", "French")),
            new Country("Hungary", 9874784, "Budapest", Arrays.asList("Hungarian")),
            new Country("Mexico", 123166749, "Mexico City", Arrays.asList("Spanish")),
            new Country("Uruguay", 3351016, "Montevideo", Arrays.asList("Spanish"))
    );

    public Country findByName(String name) {
        for(Country country : ALL_COUNTRIES) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public List<Country> sortByPopulation() {
        List<Country> sortedPopulation = ALL_COUNTRIES.stream().sorted((c1, c2) -> c1.getPopulationAsInt() - c2.getPopulationAsInt()).collect(Collectors.toList());
        return sortedPopulation;
    }
}
