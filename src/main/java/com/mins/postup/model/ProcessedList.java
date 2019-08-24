package com.mins.postup.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProcessedList {

    private Integer List_id;
    private String List_name;

    //add null info for front access
    private List cardlist;

    public ProcessedList(Integer list_id, String list_name) {
        this.List_id = list_id;
        this.List_name = list_name;
        this.cardlist = null;
    }
}
