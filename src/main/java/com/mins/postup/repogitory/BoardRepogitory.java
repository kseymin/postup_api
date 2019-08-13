package com.mins.postup.repogitory;

import com.mins.postup.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepogitory extends JpaRepository<Board,Integer> {
}
