package com.mins.postup.controller;

import com.mins.postup.entity.Card;
import com.mins.postup.entity.List;
import com.mins.postup.service.CardService;
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

    @Autowired
    CardService cardService;

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


    //find card to list_id
    @PostMapping("/cards/id")
    public java.util.List<Card> findcards(@RequestBody Map<String,Object> object) {
        Integer list_id = Integer.parseInt(object.get("id").toString());

        Optional<List> olist= listService.findById(list_id);
        List list = olist.get();

        return cardService.findByList(list);

    }


    //delete
    @DeleteMapping("/id")
    public List delete(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return listService.delete(id);
    }

    //update
    //@PostMapping("/update")
    @PutMapping("/update")
    public List update(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        String name = object.get("name").toString();

        return listService.update(id,name);
    }
}
