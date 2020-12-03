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
public class StraightRecogniserImplTest {

    @InjectMocks
    private StraightRecogniserImpl straightRecogniser;

    @Test
    public void recogniseStraight_Test_Straight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(4, Suit.DIAMOND));
        hand.add(new Card(8, Suit.HEART));
        hand.add(new Card(6, Suit.CLUB));
        hand.add(new Card(9, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_Pair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(4, Suit.DIAMOND));
        hand.add(new Card(4, Suit.HEART));
        hand.add(new Card(6, Suit.CLUB));
        hand.add(new Card(9, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_TwoPair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(4, Suit.DIAMOND));
        hand.add(new Card(4, Suit.HEART));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_ThreeOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(4, Suit.DIAMOND));
        hand.add(new Card(4, Suit.HEART));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_Flush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(8, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_FullHouse () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
    }

    @Test
    public void recogniseStraight_Test_FourOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.SPADE));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        straightRecogniser.recogniseStraight(person);

        assertNotEquals(4, person.getHandValue());
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

        straightRecogniser.recogniseStraight(person);
        //Asserts true because Straight Flush overrides Straight.
        assertEquals(4, person.getHandValue());
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

        straightRecogniser.recogniseStraight(person);
        //Asserts true because Royal Flush overrides Straight.
        assertEquals(4, person.getHandValue());
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

        straightRecogniser.recogniseStraight(person);

        assertEquals(4, person.getHandValue());
    }
}
