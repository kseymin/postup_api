package com.mins.postup.service;

import com.mins.postup.entity.CardContent;

import java.util.List;
import java.util.Optional;

public interface CardContentService {
    List<CardContent> findAll();
    Optional<CardContent> findById(Integer id);

    CardContent making(String name, String contents , Integer card_id);
}
