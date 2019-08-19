package com.mins.postup.service;

import com.mins.postup.entity.Team;
import com.mins.postup.repogitory.TeamRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepogitory teamRepogitory;


    @Override
    public List<Team> findall() {
        return teamRepogitory.findAll();
    }

    @Override
    public Optional<Team> findbyid(Integer id) {
        return teamRepogitory.findById(id);
    }


    @Override
    public Team delete(Integer id) {
        Optional<Team> tmpteam = teamRepogitory.findById(id);
        Team team = tmpteam.get();

        //다비우기
        team.getUsers().clear();
        teamRepogitory.save(team);
        teamRepogitory.delete(team);

        return team;
    }

    @Override
    public Team makeTeam(String name , String description) {
        Team team = new Team(name,description);
        teamRepogitory.save(team);
        return team;
    }

}
