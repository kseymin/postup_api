package com.mins.postup.service;

import com.mins.postup.entity.Card;
import com.mins.postup.entity.CardContent;
import com.mins.postup.repogitory.CardContentRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardContentServiceImpl implements CardContentService {
    @Autowired
    CardContentRepogitory cardContentRepogitory;

    @Autowired
    CardService cardService;

    @Override
    public List<CardContent> findAll() {
        return cardContentRepogitory.findAll();
    }

    @Override
    public Optional<CardContent> findById(Integer id) {
        return cardContentRepogitory.findById(id);
    }

    @Override
    public CardContent making(String name, String contents, Integer card_id) {
        Optional<Card> tmpcard = cardService.findById(card_id);
        Card card = tmpcard.get();

        CardContent cc = new CardContent(name,contents,card);
        cardContentRepogitory.save(cc);

        return cc;
    }

    @Override
    public CardContent delete(Integer cardcontent_id) {
        Optional<CardContent> tmpcard = cardContentRepogitory.findById(cardcontent_id);
        CardContent cc = tmpcard.get();
        cardContentRepogitory.delete(cc);
        return cc;
    }


    //update
    @Override
    public CardContent update(Integer cardcontent_id, String name, String contents) {
        Optional<CardContent> tmpcard = cardContentRepogitory.findById(cardcontent_id);
        CardContent cc = tmpcard.get();
        cc.setName(name);
        cc.setContents(contents);
        cardContentRepogitory.save(cc);

        return cc;
    }

    @Override
    public List<CardContent> findbyCard(Card card) {
//        Optional<CardContent> tmpcard = cardContentRepogitory.findById(cc_id);
//        CardContent cc = tmpcard.get();

        List<CardContent> ccList = cardContentRepogitory.findByCard(card);

        return ccList;
    }
}
