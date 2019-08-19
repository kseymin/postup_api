package com.mins.postup.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cardcontent_id" ,updatable = true)
    private CardContent cardContent;

    @Column(name = "datafiles")
    private String datafiles;

    public Data(CardContent cardContent,String datafiles){
        this.cardContent = cardContent;
        this.datafiles = datafiles;

    }
}
