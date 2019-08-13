package com.mins.postup.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "DATA")
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardcontent_id" ,updatable = true)
    private CardContent cardContent;

    @Column(name = "datafiles")
    private String datafiles;
}
