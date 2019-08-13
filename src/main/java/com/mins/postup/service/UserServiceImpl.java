package com.mins.postup.service;

import com.mins.postup.entity.Team;
import com.mins.postup.entity.User;
import com.mins.postup.repogitory.TeamRepogitory;
import com.mins.postup.repogitory.UserRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepogitory UserRepogitory;

    @Autowired
    TeamService teamService;


    @Override
    public List<User> findAll() {
        return UserRepogitory.findAll();
    }

    @Override
    public User create(String user_id, String pwd, String email, String name) {
        User user = new User(user_id,pwd,email,name);
        UserRepogitory.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        return UserRepogitory.findById(id);
    }

    @Override
    public Optional<User> findByUserid(String user_id) {

        return UserRepogitory.findByUserid(user_id);
    }

    @Override
    public User changeInfo(Long id,String newPwd, String newEmail, String newName) {
//        User user = User.builder().pwd(newPwd).email(newEmail).name(newName).build();
//        user.setId(id);
//        UserRepogitory.save(user);




        Optional<User> tmpuser = UserRepogitory.findById(id);
        User user = tmpuser.get();
        user.setPassword(newPwd);
        user.setEmail(newEmail);
        user.setName(newName);
        UserRepogitory.save(user);
        return user;
    }


    @Override
    public User changePassword(Long id, String pwd) {
        Optional<User> tmpuser = UserRepogitory.findById(id);
        User user = tmpuser.get();
        user.setPassword(pwd);
        UserRepogitory.save(user);
        return user;
    }

    @Override
    public User addTeam(Long id,Integer team_id) {
        //예외처리안함 현재 팀이 없을수있음
        Optional<User> tmpUser = findById(id);
        Optional<Team> tmpteam = teamService.findbyid(team_id);

        Team team = tmpteam.get();
        User user = tmpUser.get();
        user.setTeam(team);

//
//        Optional<Team> tmpteam = teamRepogitory.findById(team_id);
//        Team team = tmpteam.get();
//
//        Optional<User> tmpUser = UserRepogitory.findById(id);
//        User user = tmpUser.get();
//        user.setTeam(team);

        UserRepogitory.save(user);



        return user;
    }


}
