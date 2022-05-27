package com.example.demo.controller;


import com.example.demo.controller.models.Concert;
import com.example.demo.controller.models.Program;
import com.example.demo.controller.models.Root;
import com.example.demo.controller.models.Work;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
class controller {
    static Root root = null;
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = new File("D:\\Users\\vsuresh\\Desktop\\largefile-jackson\\demo\\src\\main\\resources\\raw_nyc_phil.json");
        root = objectMapper.readValue(file, Root.class);
    }
    controller() throws IOException {
    }


    @RequestMapping("/hello")
    @ResponseBody
    public int hello() {
        int count = 0;
        count = (int) root.programs.stream().filter(x->x.programID>10000).count();
        return count;
    }

    @RequestMapping("/hello1")
    @ResponseBody
    public static ArrayList<String> hello1() {
        ArrayList<String> prog = new ArrayList<String>();
        root.programs.stream().forEach(y->prog.add(String.valueOf(y.orchestra)));
        return prog;
    }

    @RequestMapping("/hello2/{id}")
    @ResponseBody
    public String hello2(@PathVariable int id ) {
        Program count = root.programs.get(id);
        return count.id;
    }

    @RequestMapping("/hello3/{id}")
    @ResponseBody
    public List<Concert> hello3(@PathVariable String id )  {
        List<Concert> ret = new ArrayList<Concert>();
        for (Program p : root.programs){
            if(id.equals(p.season))
            {
                ret.addAll(p.concerts) ;
            }
            System.out.println(id+" "+p.season);
        }
        return ret;
    }

    @RequestMapping("/hello4/{id}")
    @ResponseBody
    public List<Concert> hello4(@PathVariable String id )  {
        List<Concert> ret = new ArrayList<Concert>();
        for (Program p : root.programs){
            for (Work w : p.works){
                if(id.equals(w.iD))
                {
                    ret.addAll(p.concerts) ;
                    break;
                }
                System.out.println(id+" "+p.season);
            }
        }
        return ret;
    }

    @RequestMapping("/hello5/{id}")
    @ResponseBody
    public Set<String> hello5(@PathVariable String id )  {
        Set<String> s = new HashSet<String>();
        List<Concert> ret = new ArrayList<Concert>();
        for (Program p : root.programs){
            for (Work w : p.works){
                if(w.composerName!= null && w.composerName.contains(id)) {
                    for (Concert c : p.concerts) {
                        s.add(c.venue);
                    }
                    break;
                }
            }

        }
        return s;
    }

}
