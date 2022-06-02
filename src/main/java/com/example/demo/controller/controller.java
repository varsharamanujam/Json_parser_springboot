package com.example.demo.controller;

import com.example.demo.dto.Concert;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
class controller {

   // @Autowired
   // private static service service1;


    @RequestMapping(value = "/orchestra",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public static ArrayList<String> hello1() {

        return service.orchestra();
    }

    @RequestMapping  (value="/number_of_programID_greater_than/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int hello(@PathVariable int id ) {
        return service.programid(id);
    }


    @RequestMapping(value = "/concerts_of_the_season/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Concert> hello3(@PathVariable String id )  {

        return service.concertsofseason(id);
    }

    @RequestMapping(value="/concerts_of_workID/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Concert> hello4(@PathVariable String id )  {

        return service.concertsofworkid(id);
    }

    @RequestMapping(value="/venues_at_the_composer_performed/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int hello5(@PathVariable String id )  {

        return service.composervenue(id);
    }
}