package com.mins.postup.service;

import com.mins.postup.entity.Card;
import com.mins.postup.repogitory.CardRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepogitory cardRepogitory;

    @Autowired
    ListService listService;

    @Override
    public List<Card> findAll() {
        return cardRepogitory.findAll();
    }

    @Override
    public Optional<Card> findById(Integer card_id) {
        return cardRepogitory.findById(card_id);
    }

    @Override
    public Card making(String name, String description, Integer list_id) {
        Optional<com.mins.postup.entity.List> tmplist = listService.findById(list_id);
        com.mins.postup.entity.List list  =tmplist.get();

        Card card = new Card(name,description,list);
        cardRepogitory.save(card);

        return card;
    }
}
