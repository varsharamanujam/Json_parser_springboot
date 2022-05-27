package com.example.demo.controller;


import com.example.demo.controller.models.Program;
import com.example.demo.controller.models.Root;
import com.example.demo.controller.models.Work;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Controller
class controller {
	
	static Root root = null;
    
	{
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		File file = new File("D:\\Users\\vsuresh\\Desktop\\largefile-jackson\\final\\demo\\src\\main\\resources\\raw_nyc_phil.json");
        root = objectMapper.readValue(file, Root.class);
	}
        
    


    controller() throws IOException {
    }


    @RequestMapping("/hello")
    @ResponseBody
    public int hello() {
        int count = 0;
        
                count = (int) root.programs.stream().filter(x->x.programID>10000).count();
                //root.programs.stream().forEach(y->System.out.println(y.orchestra));


        return count;
    }

    @RequestMapping("/hello1")
    @ResponseBody
    public static @NotNull ArrayList<String> hello1() {
        ArrayList<String> prog = new ArrayList<String>();
        root.programs.stream().forEach(y->prog.add(String.valueOf(y.orchestra)));
        //System.out.println(root.programs.get(0).programID);
        //root.programs.stream().forEach(y->System.out.println(y.programID));
        //count = (int) root.programs.stream().filter(x->x.programID>10000).count();
        //str = root.programs.stream().forEach(y->System.out.println(y.orchestra));
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
    public String hello21(@PathVariable int id ) {
        
   
    	
    	Program count = root.programs.get(id);
    	
    	
    	
        return count.id;
    }
}