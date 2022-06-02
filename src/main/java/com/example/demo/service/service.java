package com.example.demo.service;

import com.example.demo.dto.Concert;
import com.example.demo.dto.Program;
import com.example.demo.dto.Root;
import com.example.demo.dto.Work;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class service {
    static Root root = null;

    {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = new File("D:\\Users\\vsuresh\\Desktop\\largefile-jackson\\raw_nyc\\src\\main\\resources\\raw_nyc_phil.json");
        try {
            root = objectMapper.readValue(file, Root.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> orchestra()
    {
        ArrayList<String> prog = new ArrayList<String>();
        root.programs.stream().forEach(y->prog.add(String.valueOf(y.orchestra)));
        return prog;
    }
    public static int  programid(int a)
    {
        int count = 0;
        count = (int) root.programs.stream().filter(x->x.programID>a).count();
        return count;
    }
    public static List<Concert> concertsofseason(String id) {
        List<Concert> ret = new ArrayList<Concert>();
        for (Program p : root.programs){
            if(id.equals(p.season))
            {
                ret.addAll(p.concerts) ;
            }
            //System.out.println(id+" "+p.season);
        }
        return ret;
    }
    public static List<Concert> concertsofworkid(String id )  {
        List<Concert> ret = new ArrayList<Concert>();
        for (Program p : root.programs){
            for (Work w : p.works){
                if(id.equals(w.iD))
                {
                    ret.addAll(p.concerts) ;
                    break;
                }
                //System.out.println(id+" "+p.season);
            }
        }
        return ret;
    }
    public static int composervenue(String id )  {
        int a=0;
        Set<String> s = new HashSet<String>();
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
        return a;
    }
}
