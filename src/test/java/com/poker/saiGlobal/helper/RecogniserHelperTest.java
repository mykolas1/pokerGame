package com.poker.saiGlobal.helper;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.enums.Suit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class RecogniserHelperTest {

    @Test
    public void hasCountOfCardsByGivenCounter_Test_Success () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));

        assertTrue(RecogniserHelper.hasCountOfCardsByGivenCounter(hand, 2).isCombinationFound()); {
        }
    }

    @Test
    public void hasCountOfCardsByGivenCounter_Test_Fail () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));

        assertFalse(RecogniserHelper.hasCountOfCardsByGivenCounter(hand, 3).isCombinationFound()); {
        }
    }

    @Test
    public void sortCards_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));

        Object[] notSorted = hand.stream().map(Card::getRank).toArray();
        Object[] sorted = RecogniserHelper.sortCards(hand).stream().map(Card::getRank).toArray();
        if (Arrays.equals(notSorted, sorted)) {
            Assert.fail();
        }
    }

    @Test
    public void areAllCardsSameSuite_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));
        hand.add(new Card(12, Suit.CLUB));
        hand.add(new Card(13, Suit.CLUB));
        hand.add(new Card(14, Suit.CLUB));

        assertTrue(RecogniserHelper.areAllCardsSameSuite(hand));
    }

    @Test
    public void fillPersonWithCombinationInformation_Test () {
        Person person = new Person(1);
        RecogniserHelper.fillPersonWithCombinationInformation(person, 2, 10);
        assertEquals(2, person.getHandValue());
        assertEquals(10, person.getHighCombinationCard());
    }
}
