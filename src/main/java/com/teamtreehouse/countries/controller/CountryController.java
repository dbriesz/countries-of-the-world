package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    // Mapping for the index page
    @RequestMapping("/")
    public String listCountries(@RequestParam(name = "sort", defaultValue = "", required = false) String sort, ModelMap modelMap) {
        List<Country> countries;
        switch (sort) {

            // If the sort selected is "population", the mapping is set to sort by population size by calling the sortByPopulation method
            case "population":
                countries = countryRepository.sortByPopulation();
                break;

            /* If the sort selected is "alphabetical", the mapping is set to sort
            alphabetically by population name by calling the sortByName method */
            case "alphabetical":
                countries = countryRepository.sortByName();
                break;

            // Default mapping in no particular order
            default:
                countries = countryRepository.getAllCountries();
                break;
        }

        // Adds the list of countries to the ModelMap and returns the index page
        modelMap.put("countries",countries);
        return "index";
    }

    // Mapping to detail page
    @RequestMapping("/country/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {

        // Calls the findByName method in order to set the detail page mapping to the individual country
        Country country = countryRepository.findByName(name);

        // Add the specific country to the ModelMap and returns the country details page
        modelMap.put("country",country);
        return "country-details";
    }
}
