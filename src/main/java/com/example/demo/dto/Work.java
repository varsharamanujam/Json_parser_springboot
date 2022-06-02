package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Work{
    public String conductorName;

    @JsonProperty("ID")
    public String iD;
    public List<Soloist> soloists = new ArrayList<>();
    @JsonProperty("composerName")
    public String composerName;
    public String interval;
}
