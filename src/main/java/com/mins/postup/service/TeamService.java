package com.mins.postup.service;

import com.mins.postup.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team makeTeam(String name, String description);

    List<Team> findall();

    Optional<Team> findbyid(Integer id);

    Team delete(Integer id);

    Team update(Integer id,String name,String description);
}
