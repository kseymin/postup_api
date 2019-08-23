package com.mins.postup.service;

import com.mins.postup.entity.Board;
import com.mins.postup.entity.User;
import com.mins.postup.repogitory.BoardRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardRepogitory boardRepogitory;

    @Autowired
    UserService userService;


    @Override
    public Optional<Board> findById(Integer id) {
        return boardRepogitory.findById(id);
    }

    @Override
    public Board making(Long user_id ,String name, String description) {
        Optional<User> tmpuser = userService.findById(user_id);
        User user = tmpuser.get();

        Board board = new Board(name,description,user);
        boardRepogitory.save(board);
        return board;
    }

    @Override
    public List<Board> findAll() {
        return boardRepogitory.findAll();
    }

    @Override
    public List<Board> findByUser_id(Long user_id) {
        Optional<User> tmpuser = userService.findById(user_id);
        User user = tmpuser.get();

        List<Board> boardList = boardRepogitory.findByUser(user);

        return boardList;
    }

    @Override
    public List<Board> findByUser(User user) {
        return boardRepogitory.findByUser(user);
    }

    @Override
    public Board delete(Integer board_id) {
        Optional<Board> tmpboard= boardRepogitory.findById(board_id);
        Board board = tmpboard.get();

        boardRepogitory.delete(board);
        return board;
    }

    @Override
    public Board update(Integer id, String name, String description) {
        Optional<Board> tmpboard= boardRepogitory.findById(id);
        Board board = tmpboard.get();

        board.setName(name);
        board.setDescription(description);
        boardRepogitory.save(board);
        return board;
    }


}
