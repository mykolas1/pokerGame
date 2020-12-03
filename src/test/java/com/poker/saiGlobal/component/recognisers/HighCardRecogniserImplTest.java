package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.enums.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HighCardRecogniserImplTest {

    @InjectMocks
    private HighCardRecogniserImpl highCardRecogniser;

    @Test
    public void recogniseHighCard_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(10, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        highCardRecogniser.recogniseHighCard(person);

        assertEquals(0, person.getHandValue());
        assertEquals(10, person.getHighCard());
    }
}
