package com.mins.postup.controller;


import com.mins.postup.entity.Card;
import com.mins.postup.entity.CardContent;
import com.mins.postup.service.CardContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cardcontent")
public class CardContentController {
    @Autowired
    CardContentService cardContentService;

    @GetMapping("/findall")
    public List<CardContent> findall(){
        return cardContentService.findAll();
    }

    @PostMapping("/id")
    public Optional<CardContent> findbyId(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return  cardContentService.findById(id);
    }

    @PostMapping("/making")
    public CardContent making(@RequestBody Map<String , Object> object){

        String name = object.get("name").toString();
        String contents = object.get("contents").toString();
        Integer card_id = Integer.parseInt(object.get("card_id").toString());

        return cardContentService.making(name, contents,card_id);
    }
}
