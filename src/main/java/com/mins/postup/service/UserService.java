package com.mins.postup.service;

import com.mins.postup.entity.User;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;


public interface UserService {
    //String findById(Integer id);
    List<User> findAll();
    User create(String user_id,String pwd,String email,String name);

    //search by table Id(long)
    Optional<User> findById(long id);
    //search by user_id(String)
    Optional<User> findByUserid(String user_id);
    //change user info
    User changeInfo(Long id,String newPwd,String newEmail,String newName);
    //change user password
    User changePassword(Long id,String pwd);
    //add team
    User addTeam(Long id,Integer team_id);

    //find belongs team
    List<String> findteam(Long id);

    //delete user
    User delete(Long id);
}
