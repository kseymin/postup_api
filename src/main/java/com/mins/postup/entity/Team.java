package com.mins.postup.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "TEAM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "description" ,nullable = true)
    private String description;

//    @OneToMany(mappedBy = "team")
//    @JsonManagedReference
//    private List<User> user ;
//



    @ManyToMany(mappedBy = "team")
    @JsonManagedReference
    private List<User> users ;

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }


    public Team(String name ,String description){
        this.name = name;
        this.description = description;
    }



}
