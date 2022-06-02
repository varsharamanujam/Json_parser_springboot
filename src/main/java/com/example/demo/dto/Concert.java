package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Concert{
    @JsonProperty("Date")
    public Date date;
    public String eventType;
    @JsonProperty("Venue")
    public String venue;
    @JsonProperty("Location")
    public String location;
    @JsonProperty("Time")
    public String time;
}
