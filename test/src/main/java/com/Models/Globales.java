package com.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Globales {
    @JsonProperty("NewConfirmed")
    public int NewConfirmed;

    @JsonProperty("TotalConfirmed")
    public int TotalConfirmed;

    @JsonProperty("NewDeaths")
    public int NewDeaths;

    @JsonProperty("TotalDeaths")
    public int TotalDeaths;

    @JsonProperty("NewRecovered")
    public int NewRecovered;

    @JsonProperty("TotalRecovered")
    public int TotalRecovered;
}