package com.mins.postup.controller;

import com.mins.postup.entity.Data;
import com.mins.postup.service.DataService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    DataService dataService;

    @GetMapping("/findall")
    public List<Data> findall(){
        return dataService.findAll();
    }

    @PostMapping("/id")
    public Optional<Data> findbyId(@RequestBody Map<String, Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return dataService.findById(id);
    }

    //delete
    @DeleteMapping("/id")
    public Data delete(@RequestBody Map<String, Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return dataService.delete(id);

    }


    @PostMapping("/making")
    public Data making(@RequestBody Map<String, Object> object){
        Integer cardContent_id = Integer.parseInt(object.get("cardcontent_id").toString());
        String datafiles = object.get("datafiles").toString();
        return dataService.making(cardContent_id,datafiles);
    }
}
