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
public class PairRecogniserImplTest {

    @InjectMocks
    private PairRecogniserImpl pairRecogniser;

    @Test
    public void recognisePair_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertEquals(1, person.getHandValue());
    }

    @Test
    public void recognisePair_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(10, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertNotEquals(1, person.getHandValue());
    }

    @Test
    public void recognisePair_Test_Straight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertNotEquals(1, person.getHandValue());
    }

    @Test
    public void recognisePair_Test_Flush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertNotEquals(1, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_StraightFlush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertNotEquals(1, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_RoyalFlush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(11, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertNotEquals(1, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_LowerStraight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        pairRecogniser.recognisePair(person);

        assertNotEquals(1, person.getHandValue());
    }
}
