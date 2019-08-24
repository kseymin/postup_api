package com.mins.postup.controller;


import com.mins.postup.entity.Card;
import com.mins.postup.entity.CardContent;
import com.mins.postup.entity.Data;
import com.mins.postup.service.CardContentService;
import com.mins.postup.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cardcontent")
public class CardContentController {
    @Autowired
    CardContentService cardContentService;

    @Autowired
    DataService dataService;

    @GetMapping("/findall")
    public List<CardContent> findall(){
        return cardContentService.findAll();
    }

    @PostMapping("/id")
    public Optional<CardContent> findbyId(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return  cardContentService.findById(id);
    }

    // find datas to CardContent
    @PostMapping("/datas/id")
    public List<Data> findDatas(@RequestBody Map<String,Object> object){
        Integer cc_id = Integer.parseInt(object.get("id").toString());

        Optional<CardContent> occ =cardContentService.findById(cc_id);
        CardContent cc = occ.get();

        return  dataService.findByCardContent(cc);
    }




    @PostMapping("/making")
    public CardContent making(@RequestBody Map<String , Object> object){

        String name = object.get("name").toString();
        String contents = object.get("contents").toString();
        Integer card_id = Integer.parseInt(object.get("card_id").toString());

        return cardContentService.making(name, contents,card_id);
    }

    //delete

    @DeleteMapping("/id")
    public CardContent delete(@RequestBody Map<String , Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return  cardContentService.delete(id);

    }

    //update
    //@PostMapping("/update")
    @PutMapping("/update")
    public CardContent update(@RequestBody Map<String , Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        String name = object.get("name").toString();
        String contents = object.get("contents").toString();
        return cardContentService.update(id,name,contents);
    }
}
