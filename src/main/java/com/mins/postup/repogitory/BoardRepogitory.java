package com.mins.postup.repogitory;

import com.mins.postup.entity.Board;
import com.mins.postup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepogitory extends JpaRepository<Board,Integer> {
    List<Board> findAll();
    Optional<Board> findById(Integer id);
    List<Board> findByUser(User user);
    //List<Board> findByIdAndUser(Integer board_id, String user_id);
}
