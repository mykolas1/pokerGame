package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

import java.util.Comparator;

/**
 * Recognises Flush combination in given hand.
 */
@Component
public class FlushRecogniserImpl implements FlushRecogniser {
    /**
     * Recognises Flush combination in given hand.
     * @param person person with 5 cards.
     */
    @Override
    public void recogniseFlush(Person person) {
        if (RecogniserHelper.areAllCardsSameSuite(person.getHand())) {
            person.getHand().sort(Comparator.comparing(Card::getRank));
            person.setHighCombinationCard(person.getHand().get(4).getRank());
            person.setHandValue(PokerHandValuesConstants.FLUSH);
        }
    }
}
