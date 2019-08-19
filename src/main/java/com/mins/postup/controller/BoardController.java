package com.mins.postup.controller;

import com.mins.postup.entity.Board;
import com.mins.postup.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/findall")
    public List<Board> findAll(){
        return boardService.findAll();
    };

    @PostMapping("/making")
    public Board make(@RequestBody Map<String,Object> object){
        Long user_id = Long.parseLong(object.get("user_id").toString());
        String name = object.get("name").toString();
        String description = object.get("description").toString();

        return boardService.making(user_id,name,description);
    }


    @PostMapping("/id")
    public Optional<Board> findById(@RequestParam Integer id) {
        return boardService.findById(id);
    }

    // 해당하는 사용자의 모든 보드를 보여줌(보드의 모든정보) , 리스트로 던져줌
    @PostMapping("/findbyuser")
    public List<Board> findByUser(@RequestBody Map<String, Object> object) {
        Integer user_id = Integer.parseInt(object.get("user_id").toString());
        return boardService.findByUser(user_id);
    }
}
