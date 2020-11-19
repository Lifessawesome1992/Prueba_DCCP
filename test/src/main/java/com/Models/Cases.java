package com.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cases {
    @JsonProperty("Message")
    public String Message;

    @JsonProperty("Global")
    public Globales Global;

    @JsonProperty("Countries")
    public List<Paises> Countries;

    @JsonProperty("Date")
    public String Date;

 }
// Generate getter and setter methods

