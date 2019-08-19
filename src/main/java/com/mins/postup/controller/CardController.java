package com.mins.postup.controller;


import com.mins.postup.entity.Card;
import com.mins.postup.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;


    @GetMapping("/findall")
    public List<Card> findall(){return cardService.findAll();}


    @PostMapping("/id")
    public Optional<Card> findById(Integer card_id) {
        return cardService.findById(card_id);
    }


    @PostMapping("/making")
    public Card making(@RequestBody Map<String,Object> object){
        String name = object.get("name").toString();
        String description = object.get("description").toString();
        Integer list_id = Integer.parseInt(object.get("list_id").toString());

        return cardService.making(name,description,list_id);

    }
    //delete
    @DeleteMapping("/id")
    public Card delete(@RequestBody Map<String , Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return cardService.delete(id);

    }

}
