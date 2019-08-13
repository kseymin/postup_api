package com.mins.postup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "CardContent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="contents")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id" ,updatable = true)
    private Card card;
}
