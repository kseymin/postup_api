package com.mins.postup.service;

import com.mins.postup.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Optional<Board> findById(Integer id);

    Board making(Long user_id,String name,String description);

    List<Board> findAll();
    List<Board> findByUser(Integer user_id);
}
