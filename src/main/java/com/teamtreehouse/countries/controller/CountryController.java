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

    @RequestMapping("/")
    public String listCountries(@RequestParam(name = "sort", defaultValue = "", required = false) String sort, ModelMap modelMap) {
        List<Country> countries;
        switch (sort) {
            case "population":
                countries = countryRepository.sortByPopulation();
                break;
            case "alphabetical":
                countries = countryRepository.sortByName();
                break;
            default:
                countries = countryRepository.getAllCountries();
                break;
        }
        modelMap.put("countries",countries);
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country",country);
        return "country-details";
    }
}
