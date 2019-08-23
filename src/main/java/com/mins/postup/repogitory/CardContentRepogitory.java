package com.mins.postup.repogitory;

import com.mins.postup.entity.Card;
import com.mins.postup.entity.CardContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardContentRepogitory extends JpaRepository<CardContent,Integer> {

    List<CardContent> findAll();
    Optional<CardContent> findById(Integer id);

    List<CardContent>findByCard(Card card);
 }
