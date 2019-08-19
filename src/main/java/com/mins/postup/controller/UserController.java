package com.mins.postup.controller;


import com.mins.postup.entity.User;
import com.mins.postup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService UserService;

    @PostMapping("/test")
    public String test(@Param("id")String id){
        System.out.println(id);
        return "gigig";
    }

    //Create
    @PostMapping("/making")
    public User put(@RequestBody Map<String,Object> object ){
        String user_id = object.get("user_id").toString();
        String pwd = object.get("pwd").toString();
        String email = object.get("email").toString();
        String name = object.get("name").toString();
        return UserService.create(user_id,pwd,email,name);
    }

    //Read all
    @GetMapping("/findall")
    public List<User> findAll() {
        return UserService.findAll();
    }

    //user search by table_id
//    @PostMapping("/id")
//    public Optional<User> findById(@RequestBody Map<String,Long> object){
//        Long id =object.get("id");
//        return UserService.findById(id);
//    }

    @PostMapping("/id")
    public Optional<User> findById(@RequestBody Map<String , Object> object){
        Long id = Long.parseLong(object.get("id").toString());
        return UserService.findById(id);
    }

    //user serach by user_id
    @PostMapping("/user_id")
    public Optional<User> findByUser_id(@RequestBody Map<String,Object> object){
        String user_id = object.get("user_id").toString();
        return  UserService.findByUserid(user_id);
    }

    //change User info
    @PostMapping("/change_info")
    public User change_info(@RequestBody User user){
        return UserService.changeInfo(user.getId(),user.getPassword(),user.getEmail(),user.getName());
    }

    //change User password
    @PostMapping("/change_pwd")
    public User change_password(@RequestBody Map<String,Object> object){
        Long id = Long.parseLong(object.get("id").toString());
        String pwd = object.get("pwd").toString();
        return UserService.changePassword(id,pwd);
    }

    //addTeam
    @PostMapping("/addteam")
    public User addTeam(@RequestBody Map<String,Object> object){
        Long id = Long.parseLong(object.get("id").toString());
        Integer team_id = Integer.parseInt(object.get("team_id").toString());
       return UserService.addTeam(id,team_id);

    }

    //find belong teams
    @PostMapping("/findteam")
    public List<String> findTeam(@RequestBody Map<String,Object> object ){
        Long id = Long.parseLong(object.get("id").toString());
        return UserService.findteam(id);

    }

}
