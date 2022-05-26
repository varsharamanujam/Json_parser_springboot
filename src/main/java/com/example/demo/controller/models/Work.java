package com.example.demo.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Work{
    public String conductorName;
    @JsonProperty("ID")
    public String iD;
    public ArrayList<Soloist> soloists;
    public String composerName;
    public String interval;
}
