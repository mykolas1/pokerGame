package com.poker.saiGlobal.component;

import com.poker.saiGlobal.component.recognisers.*;
import com.poker.saiGlobal.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Evaluates person's hand.
 */
@RequiredArgsConstructor
@Component
public class HandEvaluatorImpl implements HandEvaluator {

    private final HighCardRecogniser highCardRecogniser;
    private final PairRecogniser pairRecogniser;
    private final TwoPairRecogniser twoPairRecogniser;
    private final ThreeOfKindRecogniser threeOfKindRecogniser;
    private final StraightRecogniser straightRecogniser;
    private final FlushRecogniser flushRecogniser;
    private final FullHouseRecogniser fullHouseRecogniser;
    private final FourOfKindRecogniser fourOfKindRecogniser;
    private final StraightFlushRecogniser straightFlushRecogniser;
    private final RoyalFlushRecogniser royalFlushRecogniser;

    /**
     * Checks person hand's combination, recognises the highest and fills person's object with relevant information.
     * @param person person object which information will be updated.
     */
    @Override
    public void evaluateHand(Person person) {
        highCardRecogniser.recogniseHighCard(person);
        pairRecogniser.recognisePair(person);
        twoPairRecogniser.recogniseTwoPair(person);
        threeOfKindRecogniser.recogniseThreeOfKind(person);
        straightRecogniser.recogniseStraight(person);
        flushRecogniser.recogniseFlush(person);
        fullHouseRecogniser.recogniserFullHouse(person);
        fourOfKindRecogniser.recogniserFourOfKind(person);
        straightFlushRecogniser.recogniseStraightFlush(person);
        royalFlushRecogniser.recogniseRoyalFlush(person);
    }

}
