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
    UserService userService;



    //Create
    @PostMapping("/making")
    public User put(@RequestBody Map<String,Object> object ){
        String user_id = object.get("user_id").toString();
        String pwd = object.get("password").toString();
        String email = object.get("email").toString();
        String name = object.get("name").toString();
        return userService.create(user_id,pwd,email,name);
    }

    //Read all
    @GetMapping("/findall")
    public List<User> findAll() {
        return userService.findAll();
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
        return userService.findById(id);
    }

    //user serach by user_id
    @PostMapping("/user_id")
    public Optional<User> findByUser_id(@RequestBody Map<String,Object> object){
        String user_id = object.get("user_id").toString();
        return  userService.findByUserid(user_id);
    }

    //change User info
    //@PostMapping("/update")
    @PutMapping("/update")
    public User change_info(@RequestBody Map<String ,Object> user){
        Long id = Long.parseLong(user.get("id").toString());
        String pwd = user.get("password").toString();
        String email = user.get("email").toString();
        String name = user.get("name").toString();
        return userService.changeInfo(id,pwd,email,name);
    }

    //change User password
    @PostMapping("/change_password")
    public User change_password(@RequestBody Map<String,Object> object){
        Long id = Long.parseLong(object.get("id").toString());
        String pwd = object.get("password").toString();
        return userService.changePassword(id,pwd);
    }

    //addTeam
    @PostMapping("/addteam")
    public User addTeam(@RequestBody Map<String,Object> object){
        Long id = Long.parseLong(object.get("id").toString());
        Integer team_id = Integer.parseInt(object.get("team_id").toString());
       return userService.addTeam(id,team_id);

    }

    //find belong teams
    @PostMapping("/findteam")
    public List<String> findTeam(@RequestBody Map<String,Object> object ){
        Long id = Long.parseLong(object.get("id").toString());
        return userService.findteam(id);

    }

    //Delete user
    @DeleteMapping("/id")
    public User delete(@RequestBody Map<String,Object> object){
        Long id = Long.parseLong(object.get("id").toString());
        return userService.delete(id);

    }

    //userid check //중복되면 False 를 준다. 중복안되면 True
    @PostMapping("/check")
    public Boolean userCheck(@RequestBody Map<String,Object> object){
        String userid = object.get("user_id").toString();
        return userService.userCheck(userid);
    }

    //userid and password check // 전부맞으면 True 아니면 false
    @PostMapping("/login")
    public Boolean userLogin(@RequestBody Map<String,Object> object){
        String user_id = object.get("user_id").toString();
        String password = object.get("password").toString();

        return userService.userLogin(user_id,password);
    }

    //Login check and throw User //로그인확인하고 유저로 던져줌
    @PostMapping("/login_user")
    public User userLogin_user(@RequestBody Map<String,Object> object){
        String user_id = object.get("user_id").toString();
        String password = object.get("password").toString();

        return userService.userLogin_user(user_id,password);
    }
}
