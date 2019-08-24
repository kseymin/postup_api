package com.mins.postup.controller;


import com.mins.postup.entity.Card;
import com.mins.postup.entity.CardContent;
import com.mins.postup.service.CardContentService;
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

    @Autowired
    CardContentService cardContentService;


    @GetMapping("/findall")
    public List<Card> findall(){return cardService.findAll();}


    @PostMapping("/id")
    public Optional<Card> findById(@RequestBody Map<String,Object> object) {
        Integer card_id = Integer.parseInt(object.get("id").toString());
        return cardService.findById(card_id);
    }

    //Find cardcontents to card_id
    @PostMapping("/cardcontents/id")
    public List<CardContent> findbyLists(@RequestBody Map<String,Object> object){
        Integer card_id = Integer.parseInt(object.get("id").toString());
        Optional<Card> ocard =cardService.findById(card_id);

        Card card = ocard.get();

        return cardContentService.findbyCard(card);

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

    //update
    //@PostMapping("/update")
    @PutMapping("/update")
    public Card update(@RequestBody Map<String , Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        String name = object.get("name").toString();
        String description = object.get("description").toString();

        return cardService.update(id,name,description);
    }

}
