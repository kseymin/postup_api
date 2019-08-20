package com.mins.postup.service;

import com.mins.postup.entity.Board;
import com.mins.postup.entity.List;
import com.mins.postup.repogitory.ListRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    ListRepogitory listRepogitory;

    @Autowired
    BoardService boardService;

    @Override
    public java.util.List<List> findAll() {
        return listRepogitory.findAll();
    }

    @Override
    public Optional<List> findById(Integer id) {
        return listRepogitory.findById(id);
    }

    @Override
    public List making(Integer board_id, String name) {
        Optional<Board> tmpboard = boardService.findById(board_id);
        Board board = tmpboard.get();

        List list = new List(name,board);
        listRepogitory.save(list);

        return list;
    }

    @Override
    public List delete(Integer id) {
        Optional<List> tmplist = listRepogitory.findById(id);
        List list = tmplist.get();

        listRepogitory.delete(list);

        return list;
    }

    @Override
    public List update(Integer id, String name) {
        Optional<List> tmplist = listRepogitory.findById(id);
        List list = tmplist.get();
        list.setName(name);

        listRepogitory.save(list);

        return list;
    }
}
