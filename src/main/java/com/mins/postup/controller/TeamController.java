package com.mins.postup.controller;

import com.mins.postup.entity.Team;

import com.mins.postup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;


    @GetMapping("/findall")
    public List<Team> findall(){
        return teamService.findall();
    }

    //create Team
    @PostMapping("/making")
    public Team make(@RequestBody Map<String,Object> object){
        String name = object.get("name").toString();
        String description = object.get("description").toString();
        return teamService.makeTeam(name,description);
    }

    //search Team by id

    @PostMapping("/id")
    public Optional<Team> findbyId(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return teamService.findbyid(id);

    }

    //delete team

    @DeleteMapping("/id")
    public Team delete(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        return teamService.delete(id);

    }

    //update
    @PostMapping("/update")
    @PutMapping("/update")
    public Team update(@RequestBody Map<String,Object> object){
        Integer id = Integer.parseInt(object.get("id").toString());
        String name = object.get("name").toString();
        String description = object.get("description").toString();


        return teamService.update(id,name,description);

    }

}
