package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

/**
 * Recognises Two Pair combination in hand.
 */
@Component
public class TwoPairRecogniserImpl implements TwoPairRecogniser {

    /**
     * Recognises Two Pair combination in hand and fills person with information.
     * @param person Person with all information.
     */
    @Override
    public void recogniseTwoPair(Person person) {
        RecogniserHelper.sortCards(person.getHand());
        if (person.getHand().get(0).getRank() == person.getHand().get(1).getRank() &&
                person.getHand().get(2).getRank() == person.getHand().get(3).getRank()) {
            RecogniserHelper.fillPersonWithCombinationInformation(
                    person,
                    PokerHandValuesConstants.TWO_PAIR,
                    person.getHand().get(3).getRank());
        } else if (person.getHand().get(0).getRank() == person.getHand().get(1).getRank() &&
                person.getHand().get(3).getRank() == person.getHand().get(4).getRank()) {
            RecogniserHelper.fillPersonWithCombinationInformation(
                    person,
                    PokerHandValuesConstants.TWO_PAIR,
                    person.getHand().get(4).getRank());
        } else if (person.getHand().get(1).getRank() == person.getHand().get(2).getRank() &&
                person.getHand().get(3).getRank() == person.getHand().get(4).getRank()) {
            RecogniserHelper.fillPersonWithCombinationInformation(
                    person,
                    PokerHandValuesConstants.TWO_PAIR,
                    person.getHand().get(4).getRank());
        }
    }
}


