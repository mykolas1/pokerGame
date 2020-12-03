package com.poker.saiGlobal.dto;

import com.poker.saiGlobal.enums.Suit;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    @Getter
    private List<Card> cards;

    /**
     * Initialize cards list and fills with cards.
     */
    public Deck() {
        cards = new ArrayList<>();

        for (short i = 2; i <= 14; i++) {
            cards.add(new Card(i, Suit.CLUB));
            cards.add(new Card(i, Suit.DIAMOND));
            cards.add(new Card(i, Suit.HEART));
            cards.add(new Card(i, Suit.SPADE));
        }
    }
}
