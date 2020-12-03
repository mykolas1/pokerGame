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
public class FlushRecogniserImplTest {

    @InjectMocks
    private FlushRecogniserImpl flushRecogniser;

    @Test
    public void recogniseFlush_Test_CLUB () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(7, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(9, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_DIAMOND () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(7, Suit.DIAMOND));
        hand.add(new Card(5, Suit.DIAMOND));
        hand.add(new Card(9, Suit.DIAMOND));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_SPADE () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(3, Suit.SPADE));
        hand.add(new Card(7, Suit.SPADE));
        hand.add(new Card(5, Suit.SPADE));
        hand.add(new Card(9, Suit.SPADE));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_HEART () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(3, Suit.HEART));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(5, Suit.HEART));
        hand.add(new Card(9, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(3, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(5, Suit.SPADE));
        hand.add(new Card(9, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_Pair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(5, Suit.SPADE));
        hand.add(new Card(9, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_TwoPair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(3, Suit.HEART));
        hand.add(new Card(3, Suit.SPADE));
        hand.add(new Card(9, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_ThreeOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(5, Suit.SPADE));
        hand.add(new Card(9, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_Straight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(3, Suit.SPADE));
        hand.add(new Card(4, Suit.HEART));
        hand.add(new Card(5, Suit.SPADE));
        hand.add(new Card(6, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_FullHouse () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(4, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(4, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }

    @Test
    public void recogniseFlush_Test_FourOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(2, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(9, Suit.HEART));
        Person person = new Person(1);
        person.setHand(hand);

        flushRecogniser.recogniseFlush(person);

        assertNotEquals(5, person.getHandValue());
    }
}
