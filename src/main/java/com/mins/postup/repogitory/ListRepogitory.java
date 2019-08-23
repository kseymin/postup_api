package com.mins.postup.repogitory;

import com.mins.postup.entity.Board;
import com.mins.postup.entity.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListRepogitory extends JpaRepository<List,Integer> {
    java.util.List<List> findAll();
    Optional<List> findById(Integer id);
    java.util.List<List> findByBoard(Board board);

}
