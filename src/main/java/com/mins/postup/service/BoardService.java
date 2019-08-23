package com.mins.postup.service;

import com.mins.postup.entity.Board;
import com.mins.postup.entity.User;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    Optional<Board> findById(Integer id);
    Board making(Long user_id,String name,String description);
    List<Board> findAll();
    List<Board> findByUser_id(Long user_id);

    List<Board> findByUser(User user);
    Board delete(Integer board_id);

    Board update(Integer id,String name,String description);
}
