package com.mins.postup.entity;

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
//    private List<User> user = new List<User>();

}
