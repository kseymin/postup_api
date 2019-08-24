package com.mins.postup.controller;


import com.mins.postup.service.FindService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/find")
public class FindController {

    @Autowired
    FindService findService;


    @PostMapping("/joinboard/id")
    public List find_join(@RequestBody Map<String,Object> object){
        Integer board_id = Integer.parseInt(object.get("board_id").toString());

        return  findService.findall_board_info(board_id);

    }

    @PostMapping("/board/id")
    public Object find(@RequestBody Map<String,Object> object){
        Integer board_id = Integer.parseInt(object.get("board_id").toString());

        return  findService.findall_board(board_id);

    }



}
