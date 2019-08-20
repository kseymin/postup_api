package com.mins.postup.service;

import com.mins.postup.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    List<Card> findAll();
    Optional<Card> findById(Integer card_id);

    Card making(String name, String description , Integer list_id);

    Card delete(Integer card_id);

    Card update(Integer id , String name,String description);

}
