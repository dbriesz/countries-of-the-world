package com.teamtreehouse.countries.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;

public class Country {
    private String name;
    private int population;
    private String capital;
    private List<String> languages;

    public Country(String name, int population, String capital, List<String> languages) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLanguages() {
        StringJoiner joiner = new StringJoiner(", ");
        for(String language : languages) {
           joiner.add(language);
        }
        String languagesToStr = joiner.toString();
        return languagesToStr;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
