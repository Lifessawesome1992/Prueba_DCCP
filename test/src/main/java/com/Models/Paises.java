package com.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties({ "Premium", "Date" })
public class Paises {
    @JsonProperty("Country")
    public String Country;
    @JsonProperty("CountryCode")
    public String CountryCode;
    @JsonProperty("Slug")
    public String Slug;
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
    //@JsonProperty("Date")
    //public Dates Date;

}
