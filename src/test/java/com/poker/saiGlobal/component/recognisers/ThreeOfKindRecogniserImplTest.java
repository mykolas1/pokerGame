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
public class ThreeOfKindRecogniserImplTest {

    @InjectMocks
    private ThreeOfKindRecogniserImpl threeOfKindRecogniser;

    @Test
    public void recogniseThreeOfKind_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        threeOfKindRecogniser.recogniseThreeOfKind(person);

        assertEquals(3, person.getHandValue());
    }

    @Test
    public void recogniseTwoPair_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        hand.add(new Card(11, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        threeOfKindRecogniser.recogniseThreeOfKind(person);

        assertNotEquals(3, person.getHandValue());
    }

    @Test
    public void recogniseTwoPair_Test_Pair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        hand.add(new Card(11, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        threeOfKindRecogniser.recogniseThreeOfKind(person);
        assertNotEquals(3, person.getHandValue());
    }

    @Test
    public void recogniseTwoPair_Test_Straight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        threeOfKindRecogniser.recogniseThreeOfKind(person);
        assertNotEquals(3, person.getHandValue());
    }

    @Test
    public void recogniseTwoPair_Test_Flush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        threeOfKindRecogniser.recogniseThreeOfKind(person);
        assertNotEquals(3, person.getHandValue());
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

        threeOfKindRecogniser.recogniseThreeOfKind(person);
        assertNotEquals(3, person.getHandValue());
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

        threeOfKindRecogniser.recogniseThreeOfKind(person);
        assertNotEquals(3, person.getHandValue());
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

        threeOfKindRecogniser.recogniseThreeOfKind(person);
        assertNotEquals(3, person.getHandValue());
    }
}
