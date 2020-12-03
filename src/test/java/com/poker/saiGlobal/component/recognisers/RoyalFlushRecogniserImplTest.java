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
import static org.junit.Assert.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class RoyalFlushRecogniserImplTest {

    @InjectMocks
    private RoyalFlushRecogniserImpl royalFlushRecogniser;

    @Test
    public void recogniseRoyalFlush_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(11, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertEquals(9, person.getHandValue());
    }

    @Test
    public void recogniseRoyalFlush_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(11, Suit.DIAMOND));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertNotEquals(9, person.getHandValue());
    }

    @Test
    public void recogniseRoyalFlush_Test_Pair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(9, Suit.DIAMOND));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertNotEquals(9, person.getHandValue());
    }

    @Test
    public void recogniseRoyalFlush_Test_TwoPair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(9, Suit.DIAMOND));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertNotEquals(9, person.getHandValue());
    }

    @Test
    public void recogniseRoyalFlush_Test_ThreeOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(9, Suit.DIAMOND));
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertNotEquals(9, person.getHandValue());
    }

    @Test
    public void recogniseRoyalFlush_Test_FullHouse () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(9, Suit.DIAMOND));
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertNotEquals(9, person.getHandValue());
    }

    @Test
    public void recogniseRoyalFlush_Test_FourOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(9, Suit.DIAMOND));
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        royalFlushRecogniser.recogniseRoyalFlush(person);

        assertNotEquals(9, person.getHandValue());
    }
}
