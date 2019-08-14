package com.mins.postup.controller;

import com.mins.postup.entity.Team;
import com.mins.postup.entity.User;
import com.mins.postup.service.TeamService;
import com.mins.postup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Id;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService UserService;


    //Create
    @PostMapping("/making")
    public User put(@RequestParam String user_id, String pwd, String email, String name){
        return UserService.create(user_id,pwd,email,name);
    }

    //Read all
    @GetMapping("/findall")
    public List<User> findAll() {
        return UserService.findAll();
    }

    //user search by table_id
    @PostMapping("/id")
    public Optional<User> findById(@RequestParam Long id){
        return UserService.findById(id);
    }
    //user serach by user_id
    @PostMapping("/user_id")
    public Optional<User> findByUser_id(@RequestParam String user_id){
        return  UserService.findByUserid(user_id);
    }

    //change User info
    @PostMapping("/change_info")
    public User change_info(@RequestBody User user){
        return UserService.changeInfo(user.getId(),user.getPassword(),user.getEmail(),user.getName());
    }

    //change User password
    @PostMapping("/change_pwd")
    public User change_password(@RequestParam Long id ,String pwd){

        return UserService.changePassword(id,pwd);
    }

    //addTeam
    @PostMapping("/addteam")
    public User addTeam(@RequestParam Long id , Integer team_id){
       return UserService.addTeam(id,team_id);

    }

    //find belong teams
    @PostMapping("/findteam")
    public List<String> findTeam(@RequestParam Long id ){
        return UserService.findteam(id);

    }

}
