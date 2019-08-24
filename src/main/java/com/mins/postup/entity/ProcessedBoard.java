package com.mins.postup.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class ProcessedBoard {

    private Integer List_id;
    private String List_name;

    private Integer card_id;
    private String card_name;
    private String card_description;


    private Integer cardcontent_id;
    private String cardcontent_name;
    private String cardcontent_contents;


    public void setList_id(Integer list_id) {
        List_id = list_id;
    }

    public void setList_name(String list_name) {
        List_name = list_name;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public void setCard_description(String card_description) {
        this.card_description = card_description;
    }

    public void setCardcontent_id(Integer cardcontent_id) {
        this.cardcontent_id = cardcontent_id;
    }

    public void setCardcontent_name(String cardcontent_name) {
        this.cardcontent_name = cardcontent_name;
    }

    public void setCardcontent_contents(String cardcontent_contents) {
        this.cardcontent_contents = cardcontent_contents;
    }

    public Integer getList_id() {
        return List_id;
    }

    public String getList_name() {
        return List_name;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public String getCard_description() {
        return card_description;
    }

    public Integer getCardcontent_id() {
        return cardcontent_id;
    }

    public String getCardcontent_name() {
        return cardcontent_name;
    }

    public String getCardcontent_contents() {
        return cardcontent_contents;
    }


    public ProcessedBoard(Integer list_id, String list_name, Integer card_id, String card_name, String card_description, Integer cardcontent_id, String cardcontent_name, String cardcontent_contents) {
        List_id = list_id;
        List_name = list_name;
        this.card_id = card_id;
        this.card_name = card_name;
        this.card_description = card_description;
        this.cardcontent_id = cardcontent_id;
        this.cardcontent_name = cardcontent_name;
        this.cardcontent_contents = cardcontent_contents;
    }

    public ProcessedBoard(Integer list_id, String list_name, Integer card_id, String card_name, String card_description) {
        List_id = list_id;
        List_name = list_name;
        this.card_id = card_id;
        this.card_name = card_name;
        this.card_description = card_description;
    }

    public ProcessedBoard(Integer list_id, String list_name) {
        List_id = list_id;
        List_name = list_name;
    }
}
