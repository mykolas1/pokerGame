package com.poker.saiGlobal.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {

    private int id;
    private List<Card> hand;
    private int handValue;
    private int highCombinationCard;
    private int highCard;

    public Person(int id) {
        this.id = id;
        hand = new ArrayList<>();
        handValue = 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hand=" + hand +
                ", handValue=" + handValue +
                ", highCard=" + highCard +
                '}';
    }
}
