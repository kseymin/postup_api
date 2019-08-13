package com.mins.postup.repogitory;

import com.mins.postup.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepogitory extends JpaRepository<Team, Integer> {

    List<Team> findAll();
    Optional<Team> findById(Integer id);

}
