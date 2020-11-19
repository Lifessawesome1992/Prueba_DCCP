package com.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalleV {
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
