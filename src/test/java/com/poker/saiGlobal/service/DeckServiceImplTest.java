package com.poker.saiGlobal.service;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Deck;
import com.poker.saiGlobal.dto.Players;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DeckServiceImplTest {

    @InjectMocks
    private DeckServiceImpl deckService;

    @Test
    public void shuffleCards_Test () {
        Deck deck = new Deck();
        Deck newDeck = deckService.shuffleCards(new Deck());
        Object[] notShuffled = deck.getCards().stream().map(Card::getRank).toArray();
        Object[] shuffled = newDeck.getCards().stream().map(Card::getRank).toArray();
        if (Arrays.equals(notShuffled, shuffled)) {
            Assert.fail();
        }
    }

    @Test
    public void splitCards_Test () {
        Deck deck = new Deck();
        Players players = new Players(2);
        deckService.splitCards(players, deck);
        assertEquals(5, players.getPeople().get(0).getHand().size());
        assertEquals(5, players.getPeople().get(1).getHand().size());
    }
}
