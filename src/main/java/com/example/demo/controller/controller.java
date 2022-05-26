package com.example.demo.controller;


import com.example.demo.controller.models.Root;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
class controller {
    @RequestMapping("/hello")
    @ResponseBody
    public int hello() {
        int count = 0;
        {
            try{
                final ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                File file = new File("D:\\Users\\vsuresh\\Desktop\\largefile-jackson\\demo\\src\\main\\resources\\raw_nyc_phil.json");
                Root root = objectMapper.readValue(file, Root.class);
                //System.out.println(root.programs.get(0).programID);
                //root.programs.stream().forEach(y->System.out.println(y.programID));
                count = (int) root.programs.stream().filter(x->x.programID>10000).count();
                root.programs.stream().forEach(y->System.out.println(y.orchestra));
                

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        return count;
    }
}