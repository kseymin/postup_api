package com.mins.postup.controller;

import com.mins.postup.entity.Team;

import com.mins.postup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Team make(@RequestBody Team team){
        return teamService.makeTeam(team);
    }

    //search Team by id

    @PostMapping("/id")
    public Optional<Team> findbyId(@RequestParam Integer id){
//        Optional<Team> tmpteam= teamService.findbyid(id);
//        Team team = tmpteam.get();
        return teamService.findbyid(id);

    }


}
