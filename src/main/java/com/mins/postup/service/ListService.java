package com.mins.postup.service;

import com.mins.postup.entity.List;

import java.util.Optional;

public interface ListService {
    java.util.List<List> findAll();
    Optional<List> findById(Integer id);

    List making(Integer board_id, String name);

    List delete(Integer id);

    List update(Integer id , String name);

}
