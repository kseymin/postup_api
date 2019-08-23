package com.mins.postup.service;

import com.mins.postup.entity.Card;
import com.mins.postup.entity.CardContent;

import java.util.List;
import java.util.Optional;

public interface CardContentService {
    List<CardContent> findAll();
    Optional<CardContent> findById(Integer id);

    CardContent making(String name, String contents , Integer card_id);

    CardContent delete(Integer cardcontent_id);
    CardContent update(Integer cardcontent_id,String name,String contents);

    List<CardContent> findbyCard(Card card);
}
