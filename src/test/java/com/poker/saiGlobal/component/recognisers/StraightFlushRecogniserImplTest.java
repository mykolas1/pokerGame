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
public class StraightFlushRecogniserImplTest {

    @InjectMocks
    private StraightFlushRecogniserImpl straightFlushRecogniser;

    @Test
    public void recogniseStraightFlush_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertEquals(8, person.getHandValue());
    }

    @Test
    public void recogniseStraightFlush_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(6, Suit.DIAMOND));
        hand.add(new Card(7, Suit.CLUB));
        hand.add(new Card(8, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertNotEquals(8, person.getHandValue());
    }

    @Test
    public void recogniseStraightFlush_Test_Pair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(6, Suit.DIAMOND));
        hand.add(new Card(7, Suit.CLUB));
        hand.add(new Card(8, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertNotEquals(8, person.getHandValue());
    }

    @Test
    public void recogniseStraightFlush_Test_TwoPair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(8, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertNotEquals(8, person.getHandValue());
    }

    @Test
    public void recogniseStraightFlush_Test_ThreeOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(7, Suit.CLUB));
        hand.add(new Card(8, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertNotEquals(8, person.getHandValue());
    }

    @Test
    public void recogniseStraightFlush_Test_Straight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(4, Suit.DIAMOND));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertNotEquals(8, person.getHandValue());
    }

    @Test
    public void recogniseStraightFlush_Test_FullHouse () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightFlushRecogniser.recogniseStraightFlush(person);

        assertNotEquals(8, person.getHandValue());
    }
}
