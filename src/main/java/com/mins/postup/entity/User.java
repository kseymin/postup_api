package com.mins.postup.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Table
@Entity(name="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "teams_id")
    private Integer teams_id;

    @Column(name = "profile_img")
    private String profile_img;

    @Builder
    public User(String id,String pwd,String email,String name){
        this.userid = id;
        this.password = pwd;
        this.name = name;
        this.email = email;
    }


}
