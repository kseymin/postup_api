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

    @Override
    public Card delete(Integer card_id) {
        Optional<Card> tmpcard = cardRepogitory.findById(card_id);
        Card card = tmpcard.get();

        cardRepogitory.delete(card);
        return card;
    }

    //update
    @Override
    public Card update(Integer id, String name, String description) {
        Optional<Card> tmpcard = cardRepogitory.findById(id);
        Card card = tmpcard.get();

        card.setName(name);
        card.setDescription(description);
        cardRepogitory.save(card);
        return card;
    }

    @Override
    public List<Card> findByList(com.mins.postup.entity.List list) {
//        Optional<com.mins.postup.entity.List> tmplist = listService.findById(list_id);
//        com.mins.postup.entity.List list = tmplist.get();

        List<Card> cardList = cardRepogitory.findByList(list);

        return cardList;
    }
}
