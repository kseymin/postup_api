package com.mins.postup.controller;

import com.mins.postup.entity.List;
import com.mins.postup.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    ListService listService;

    @GetMapping("/findall")
    public java.util.List<List> findall(){
        return listService.findAll();
    }

    @PostMapping("/making")
    public List making(@RequestBody Map<String,Object> object){
        Integer board_id = Integer.parseInt(object.get("board_id").toString());
        String name = object.get("name").toString();
        return  listService.making(board_id,name);
    }

    @PostMapping("/id")
    public Optional<List> findById(@RequestBody Map<String,Object> object) {
        Integer id = Integer.parseInt(object.get("id").toString());
        return listService.findById(id);
    }


//    @PostMapping("/id")
//    public com.mins.postup.entity.List findbyId(){}
}
