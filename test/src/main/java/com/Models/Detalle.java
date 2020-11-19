package com.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Detalle {
    @JsonProperty("Country")
    public String Country;

    @JsonProperty("CountryCode")
    public String CountryCode;

    @JsonProperty("City")
    public String City;

    @JsonProperty("CityCode")
    public String CityCode;

    @JsonProperty("Province")
    public String Province;

    @JsonProperty("Lat")
    public String Lat;

    @JsonProperty("Lon")
    public String Lon;

    @JsonProperty("Confirmed")
    public String Confirmed;
    
    @JsonProperty("Deaths")
    public String Deaths;

    @JsonProperty("Recovered")
    public String Recovered;

    @JsonProperty("Active")
    public String Active;

    @JsonProperty("Date")
    public String Date;
}
