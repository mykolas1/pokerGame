package com.poker.saiGlobal.component;


import com.poker.saiGlobal.component.recognisers.*;
import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.enums.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HandEvaluatorImplTest {

    @InjectMocks
    private HandEvaluatorImpl handEvaluator;

    @Mock private HighCardRecogniserImpl highCardRecogniser;
    @Mock private PairRecogniser pairRecogniser;
    @Mock private TwoPairRecogniser twoPairRecogniser;
    @Mock private ThreeOfKindRecogniser threeOfKindRecogniser;
    @Mock private StraightRecogniser straightRecogniser;
    @Mock private FlushRecogniser flushRecogniser;
    @Mock private FullHouseRecogniser fullHouseRecogniser;
    @Mock private FourOfKindRecogniser fourOfKindRecogniser;
    @Mock private StraightFlushRecogniser straightFlushRecogniser;
    @Mock private RoyalFlushRecogniser royalFlushRecogniser;

    @Test
    public void evaluateHand_Test () {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(1, Suit.CLUB));
        hand.add(new Card(1, Suit.CLUB));
        hand.add(new Card(1, Suit.CLUB));
        hand.add(new Card(1, Suit.CLUB));
        hand.add(new Card(1, Suit.CLUB));
        Person person = new Person(1);
        person.setHand(hand);

        Mockito.doNothing().when(highCardRecogniser).recogniseHighCard(any());
        Mockito.doNothing().when(pairRecogniser).recognisePair(person);
        Mockito.doNothing().when(twoPairRecogniser).recogniseTwoPair(person);
        Mockito.doNothing().when(threeOfKindRecogniser).recogniseThreeOfKind(person);
        Mockito.doNothing().when(straightRecogniser).recogniseStraight(person);
        Mockito.doNothing().when(flushRecogniser).recogniseFlush(person);
        Mockito.doNothing().when(fullHouseRecogniser).recogniserFullHouse(person);
        Mockito.doNothing().when(fourOfKindRecogniser).recogniserFourOfKind(person);
        Mockito.doNothing().when(straightFlushRecogniser).recogniseStraightFlush(person);
        Mockito.doNothing().when(royalFlushRecogniser).recogniseRoyalFlush(person);

        handEvaluator.evaluateHand(person);

        verify(highCardRecogniser, times(1)).recogniseHighCard(person);
        verify(pairRecogniser, times(1)).recognisePair(person);
        verify(twoPairRecogniser, times(1)).recogniseTwoPair(person);
        verify(threeOfKindRecogniser, times(1)).recogniseThreeOfKind(person);
        verify(straightRecogniser, times(1)).recogniseStraight(person);
        verify(flushRecogniser, times(1)).recogniseFlush(person);
        verify(fullHouseRecogniser, times(1)).recogniserFullHouse(person);
        verify(fourOfKindRecogniser, times(1)).recogniserFourOfKind(person);
        verify(straightFlushRecogniser, times(1)).recogniseStraightFlush(person);
        verify(royalFlushRecogniser, times(1)).recogniseRoyalFlush(person);
    }

}
