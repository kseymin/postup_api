package com.mins.postup.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Table
@Entity(name = "board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    // OnDelete => 참조한 부모가 없어지면 자식도 삭제해버리기
    @JoinColumn(name = "user_id" ,updatable = true)
    private User user;


    public Board(String name,String description,User user){
        this.name = name;
        this.description = description;
        this.user = user;
    }

}
