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
public class FullHouseRecogniserImplTest {

    @InjectMocks
    private FullHouseRecogniserImpl fullHouseRecogniser;

    @Test
    public void recogniseFullHouse_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.HEART));
        hand.add(new Card(3, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_HighCard () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(3, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_Pair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(3, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_TwoPair () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(3, Suit.HEART));
        hand.add(new Card(4, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_ThreeOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.HEART));
        hand.add(new Card(4, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_Straight () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.DIAMOND));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.HEART));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_Flush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(7, Suit.CLUB));
        hand.add(new Card(9, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_FourOfKind () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_StraightFlush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(2, Suit.CLUB));
        hand.add(new Card(3, Suit.CLUB));
        hand.add(new Card(4, Suit.CLUB));
        hand.add(new Card(5, Suit.CLUB));
        hand.add(new Card(6, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }

    @Test
    public void recogniseFullHouse_Test_RoyalFlush () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(11, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        fullHouseRecogniser.recogniserFullHouse(person);

        assertNotEquals(6, person.getHandValue());
    }
}
