package com.mins.postup.repogitory;

import com.mins.postup.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepogitory extends JpaRepository<Card,Integer> {
    List<Card> findAll();
    Optional<Card> findById(Integer card_id);
    List<Card> findByList (com.mins.postup.entity.List list);
}
