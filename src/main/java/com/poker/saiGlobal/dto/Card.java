package com.poker.saiGlobal.dto;

import com.poker.saiGlobal.enums.Suit;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Card {
    private int rank;
    private Suit suit;

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
