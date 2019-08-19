package com.mins.postup.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table
@Entity(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //json remove this string "hibernateLazyInitializer": {}
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "userid" ,unique = true)
    private String userid;

    @Column(name = "name")
    private String name;

    @Column(name="pwd")
    private String password;

    @Column(name="email")
    private String email;



    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="user_team",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    @JsonBackReference
    private List<Team> team = new ArrayList<>() ;

    @Column(name = "profile_img")
    private String profile_img;


    //set team

//    public void setTeam(List<Team> team){
//
//        if (this.team != null){
//           this.team.remove(this);
//        }
//
//
//        this.team = team;
//        this.team.add(team);
//
//    }

    public void addTeam(Team team){
        this.team.add(team);
    }

    public void removeTeam(Team team){
        this.team.remove(team);
    }


    @Builder
    public User(String id,String pwd,String email,String name){
        this.userid = id;
        this.password = pwd;
        this.name = name;
        this.email = email;
    }


}
