package com.poker.saiGlobal.service;

import com.poker.saiGlobal.dto.Deck;
import com.poker.saiGlobal.dto.Players;

/**
 * DeckServiceImpl interface.
 */
public interface DeckService {
    Deck shuffleCards(Deck deck);
    Players splitCards(Players players, Deck deck);
}
