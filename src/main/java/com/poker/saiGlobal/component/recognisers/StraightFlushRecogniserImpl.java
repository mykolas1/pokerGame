package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;

/**
 * Recognises Straight Flush into the person's hand.
 */
@Primary
@Component
public class StraightFlushRecogniserImpl extends StraightRecogniserImpl implements StraightFlushRecogniser {
    /**
     * Recognises Straight Flush into the person's hand.
     * @param person person with information.
     */
    @Override
    public void recogniseStraightFlush(Person person) {
        if (RecogniserHelper.areAllCardsSameSuite(person.getHand()) && isStraight(person.getHand())) {
            person.getHand().sort(Comparator.comparing(Card::getRank));
            person.setHighCombinationCard(person.getHand().get(4).getRank());
            person.setHandValue(PokerHandValuesConstants.STRAIGHT_FLUSH);
        }
    }
}
