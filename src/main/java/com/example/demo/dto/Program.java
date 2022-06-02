package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class Program{
    public String season;
    public String orchestra;
    public List<Concert> concerts = new ArrayList<>();
    public int programID;
    public List<Work> works = new ArrayList<>();
    public String id;
}