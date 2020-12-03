package com.poker.saiGlobal.service;

import com.poker.saiGlobal.dto.Deck;
import com.poker.saiGlobal.dto.Players;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Deck service implementation class which handles deck logic.
 */
@Service
@RequiredArgsConstructor
public class DeckServiceImpl implements DeckService {

    /**
     * Shuffles given deck.
     * @param deck deck with 52 cards.
     * @return randomly shuffled deck.
     */
    @Override
    public Deck shuffleCards(Deck deck) {
        Collections.shuffle(deck.getCards());
        return deck;
    }

    /**
     * Splits cards from the deck to players.
     * @param players Players.
     * @param deck Shuffled deck.
     * @return HashSet of people with cards in hands.
     */
    @Override
    public Players splitCards(Players players, Deck deck) {
        for (var i = 0; i < 5; i++){
            players.getPeople().forEach(person -> {
                person.getHand().add(deck.getCards().get(deck.getCards().size()-1));
                deck.getCards().remove(deck.getCards().get(deck.getCards().size()-1));
            });
        }
        return players;
    }
}
