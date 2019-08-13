package com.mins.postup.service;

import com.mins.postup.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team makeTeam(Team team);

    List<Team> findall();

    Optional<Team> findbyid(Integer id);

}
