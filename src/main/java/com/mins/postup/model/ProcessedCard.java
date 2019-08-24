package com.mins.postup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProcessedCard {

    private Integer list_id;
    private String List_name;

    private List cardlist;


    public ProcessedCard(Integer list_id, String list_name, List cardlist) {
        this.list_id = list_id;
        List_name = list_name;
        this.cardlist = cardlist;
    }


    public ProcessedCard(ProcessedList list, List cardList) {
        this.list_id = list.getList_id();
        this.List_name = list.getList_name();
        this.cardlist = cardList;
    }

}
